var commonUtils;

(typeof global == 'undefined' ? window : global).commonUtils = commonUtils = {

    common : {},
    constants : {},
    value : {},
    data : {},
    net : {},
    draw : {},
    func : {},
    modal : {},
    view : {},
    form : {}
};

Date.prototype.formattedDate = function (pattern) {
    formattedDate = pattern.replace('yyyy', this.getFullYear().toString());
    var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
    mm = mm.length > 1 ? mm : '0' + mm;
    formattedDate = formattedDate.replace('mm', mm);
    var dd = this.getDate().toString();
    dd = dd.length > 1 ? dd : '0' + dd;
    formattedDate = formattedDate.replace('dd', dd);
    return formattedDate;
};

commonUtils.form.serviceForm = undefined;

commonUtils.func.loading = function(data) {

    if(data == undefined) {
        return;
    }

    if(data.show == undefined) {
        return;
    }

    if(data.show) {
        $('.showbox').removeClass('hide');
    } else {
        $('.showbox').addClass('hide');
    }

};


commonUtils.func.okname = function() {

    var $okNameForm = $('#okname-auth').find('form').eq(0);

    $okNameForm.find('input[name="name"]').val($('input.input_small[name="name"]').val());

    var date = new Date(parseInt($('[name="birth_year"]').val()), parseInt($('[name="birth_month"]').val())-1, $('[name="birth_day"]').val());
    $okNameForm.find('input[name="birthday"]').val(date.formattedDate('yyyymmdd'));

    $okNameForm.find('input[name="gender"]').val($('select[name="gender"]').val()==1?1:0);

    $okNameForm.find('input[name="tel_com_cd"]').val($('select[name="tel_com_cd"]').val());

    $okNameForm.find('input[name="tel_no"]').val($('input.input_small[name="phone"]').val());

    window.open("", "auth_popup", "width=430,height=590,scrollbar=yes");

    var okNameform = document['form-okname'];
    okNameform.target = "auth_popup";
    okNameform.submit();

};

//같은 셀렉트를 선택했을때 막기위함
commonUtils.func.overlapCheck = function(resultValue){

    var tempSelectData = $('.reser1 select');
    var tempName = "#"+resultValue.name;

    var tempArr = new Array();
    tempArr.length = 0; //초기화

    //유효성 검사 (각 셀렉트의 갯수만큼 검사 eq(i)는 셀렉트의 갯수 의미)
    for(var i=0; i<tempSelectData.length; i++){
        tempArr.push($(tempSelectData).eq(i).val());
    }

    if(tempArr.indexOf($(tempName).val()) == 0){ //중복체크
            alert("같은 옵션은 선택하실 수 없습니다.\n다른 옵션이 필요하신 경우만 선택하여주세요. ");
            $(tempName).val("0"); //중복인 경우는 다시 0으로 선택하도록 처리
            return false;
    }


    commonUtils.func.calc();
};

commonUtils.func.autoCheck = function() {
    $('#petKind')[0].checked = true;
    $('#startDay').val('2016-02-28');
    $('#endDay').val('2016-02-29');
    $('#reservationTypeValue').val(1);
    reservationType(priceList);
    setTimeout(function() {
        $('#reservationDetailType').val(1);
        $('#optionTypeChoice1').val(1);
        $('.input-service-pet')[0].checked = true;
        commonUtils.func.calc();
    }, 100);

};

commonUtils.func.calc = function() {

    var data = priceList;

    // 1:위탁, 2:방문
    var sitterType = $('select[name="reservationTypeValue"]').val();

    // 1:당일돌봄, 2:1박일 돌봄
    var sitterTypeDetail = $('select[name="reservationDetailType"]').val();


    // 펫 목록
    var petList = [];
    var petNames = [];
    var isStop = false;
    $('input.input-pet[type="checkbox"]:checked').each(function() {
        var petName = $(this).closest('li').find('label').find('span').text();
        var item = {
            id : $(this).val(),
            name : petName,
            size : $(this).data('size')
        };

        petList.push(item);

        if(sitterType == 1) {
            if(data['rentService' + (item.size+1)] == 0) {
                isStop = true;
            }
        }

        petNames.push(petName);
    });

    if(isStop) {
        $('.content-snow-main').addClass('hide');
        alert('펫시터가 수용하지 않는 크기입니다.');
        return;
    }


    // 서비스옵션에서 필요없는 펫들 삭제
    $('input.input-service-pet').closest('li').css({display:'block'});
    $('input.input-service-pet').each(function() {

        var isChecked = false;
        for(var i=0; i<petList.length; i++) {
            var item = petList[i];

            if(item.id == $(this).val()) {
                isChecked = true;
                break;
            }
        }

        if(!isChecked) {
            $(this).closest('li').css({display:'none'});
        }
    });

    // 예약 날짜
    var bookingDate = {
        'startDate' : $('#startDay').val(),
        'endDate' : $('#endDay').val()
    };

    // 계산을 위한 필요 데이터 정의
    var keyData = {
        'sitterType' : ['', 'rent', 'visit'],
        'sitterTypeText' : ['', '위탁', '방문'],
        'sitterDetailType' : {
            1 : ['', '당일 돌봄(12시간)', '', '', '1박2일 돌봄(24시간)'],
            2 : ['', '1일 1회(30분)', '1일 2회(60분)', '당일 돌봄(12시간)', '1박2일 돌봄(24시간)']
        },
        'sitterDiscountKey' : {
            1 : ['7', '8', '9'], // 위탁의 장기할인률 컬림 뒤에 숫자 (30일 이내, 6개월 이내, 그 이상)
            2 : ['5', '6'] // 방문의 장기할인률 컬림 뒤에 숫자 (30일 이내, 그 이상)
        },
        'optionList' : [
            '',
            '훈련(전문가)',
            '그루밍(발톱손질/빗질/귀청소 등)',
            '당일돌봄 추가 (12시간)',
            '목욕',
            '픽업',
            '동물병원 진료',
            '산책',
            '수제간식 제공',
            '기타(문의)',
            '대형견 금액추가'
        ],
        'pickupPrice' : [
            'onewayService',
            'returnService'
        ]
    };

    // 1차 유효성 검사 시작
    if(sitterType == 0 || sitterTypeDetail == 0 || petList.length == 0) {
        $('.content-snow-main').addClass('hide');
        return;
    }

    if(bookingDate.startDate.length == 0 || bookingDate.endDate.length == 0) {
        $('.content-snow-main').addClass('hide');
        return;
    }
    // 1차 유효성 검사 종료


    // 펫시터 유형, 맡길 데이터 노출
    $('#bp-type').text(keyData.sitterTypeText[sitterType] + ' / ' + keyData.sitterDetailType[sitterType][sitterTypeDetail]);

    // 맡길 펫 수와 펫 이름들
    $('#bp-pet').text(petList.length + '마리' + '({pet_list})'.replace('{pet_list}', petNames.join(',')));


    // 날짜 계산시작하기전 당일/1박 구분
    var nDay = keyData.sitterDetailType[sitterType][sitterTypeDetail].indexOf('1박') > -1 ? 0 : 1; //당일이면 +1해줘야함으로 1

    // 맡길 예약기간 (기본날짜는 하루를 0으로 표현하기에 n+1 적용)
    var totalDay = (new Date(bookingDate.endDate) - new Date(bookingDate.startDate))/(24 * 3600 * 1000) + nDay;




    if(keyData.sitterDetailType[sitterType][sitterTypeDetail].indexOf('1박') > -1){ //1박일때
        $('#bp-date').text((totalDay+1) + '일 ({start_date} ~ {end_date})'.replace('{start_date}', bookingDate.startDate).replace('{end_date}', bookingDate.endDate));
    }
    else //당일
    {
        $('#bp-date').text(totalDay + ' 일 ({start_date} ~ {end_date})'.replace('{start_date}', bookingDate.startDate).replace('{end_date}', bookingDate.endDate));
    }
    $(".content-main form .main-rgt #totalDay").val(totalDay);
    // 2차 유효성 검사 시작
    if(totalDay == 0) {
        $('.content-snow-main').addClass('hide');
        return;
    }
    // 2차 유효성 검사 종료

    // 유효성 검사 통과 후 계산된 표 노출
    $('.content-snow-main').removeClass('hide');

    // DB컬럼명을 불러오기 위한 작업 (컬럼명 뽑아오기)
    var serviceKeyName = '{type}Service'.replace('{type}', keyData.sitterType[sitterType]);

    var resultPrice = 0;
    for(var i in petList) {
        var item = petList[i];

        var serviceKey = serviceKeyName + sitterTypeDetail;

        // 펫크기에 따른 가격변동 (위탁일때만 되도록)
        if(sitterTypeDetail == 1) {
            serviceKey = serviceKeyName + (item['size']+1);
        }

        // 선택된 타입의 기본금액 가져오기
        var selectedPrice = parseInt(data[serviceKey]);

        // 한마리 추가당 금액 가져오기
        var appendPrice = parseInt(data[serviceKey + '_1']);

        // 할인되지 않은 금액 계산
        //resultPrice = ((selectedPrice + ((petList.length-1) * appendPrice)) * totalDay);
        resultPrice += selectedPrice * totalDay;

    }

    // 할인되지 않은 금액 출력
    $('#bp-price').text(comma(resultPrice) + ' 원');
    $(".content-main form .main-rgt .content-snow-main input[name='normalPrice']").val(resultPrice); //hidden으로 값보내기

    // 할인율 가져오기
    var pDiscount = 0;
    if(totalDay >= 180 && sitterType == 1) {

        // 예약기간이 180일 이상 AND 위탁일 경우만
        // discount key 2
        pDiscount = data[serviceKeyName + keyData.sitterDiscountKey[sitterType][2]];
        $(".content-main form .main-rgt #discount").val(pDiscount);

    } else if(totalDay >= 30) {

        // 예약기간이 30일 이상
        // discount key 1
        pDiscount = data[serviceKeyName + keyData.sitterDiscountKey[sitterType][1]];
        $(".content-main form .main-rgt #discount").val(pDiscount);

    } else if(totalDay >= 7 && totalDay < 30) {

        // 예약기간이 7일이상이거나 30일 미만일 때
        // discount key 0
        pDiscount = data[serviceKeyName + keyData.sitterDiscountKey[sitterType][0]];
        $(".content-main form .main-rgt #discount").val(pDiscount);
    }

    // 할인율 출력하기
    $('#bp-discount').text(pDiscount + '%');
    $(".content-main form .main-rgt .content-snow-main input[name='longRate']").val(pDiscount); //hidden으로 값보내기

    // 할인된 금액 계산해서 출력하기
    var resultDiscountPrice = resultPrice - ((resultPrice/100) * pDiscount);
    $('#bp-discount-price').text(comma(resultDiscountPrice) + ' 원');
    $(".content-main form .main-rgt .content-snow-main input[name='sumLongRatePrice']").val(resultDiscountPrice); //hidden으로 값보내기

    // 서비스옵션 계산시작하기전에 계산해야 할 것들 찾아보기 (옵션을 선택하지 않았으면 제외시키기)
    var $oBoxObjects = $('.pay-walk').children('div');
    var nSelectCount = 0;
    for(var i=0; i<$oBoxObjects.length; i++) {
        if($oBoxObjects.find('select').val() > 0) {
            nSelectCount++;
        }
    }

    // 서비스옵션 선택된 것들이 하나도 없을 경우 return하도록 코드추가
    if(nSelectCount == 0) {

        // 서비스옵션계산시작하기전에 전체합산금액 출력하기
        $('.content-total').find('small').text(comma(resultDiscountPrice) + ' 원');
        $('.content-main form .content-total input[name="total_price"]').val(resultDiscountPrice); //hidden으로 값보내기

        return;
    }

    // 서비스옵션 가격표 폼을 이용해서 띄울 것이기 때문에 미리 함수로 준비 (여기에 작성한다고 함수가 실행되는 것은 아님)
    var doService = function() {

        // 밑에서 폼을 불러온뒤 실행됨

        // 서비스옵션가격결과를 뿌려주기 위해 초기화작업
        $('.content-option-warp').html('');

        var $optionBoxObjects = $('.pay-walk').children('div');

        var optionTotalPrice = 0;
        for(var i=0; i<$optionBoxObjects.length; i++) {

            var $select = $optionBoxObjects.eq(i).find('select');
            var $checkBoxList = $optionBoxObjects.eq(i).find('input[type="checkbox"]:checked');

            var optionIndex = $select.val();

            if(optionIndex > 0) {

                var optionPetList = [];
                var optionPetNames = [];
                $checkBoxList.each(function() {
                    var petName = $(this).closest('li').find('label').find('span').text();
                    optionPetList.push({
                        id : $(this).val(),
                        name : petName
                    });

                    optionPetNames.push(petName);
                });

                // 필요한 정보 입력
                var sForm = commonUtils.form.serviceForm;
                sForm = sForm.replace(/\{service_index\}/g, i).replace('{service_name}', keyData.optionList[optionIndex]);
                sForm = sForm.replace('{pet_count}', optionPetList.length).replace('{pet_names}', optionPetNames.join(','));
                sForm = sForm.replace('{service_count}', '1회'); // 따로 횟수를 기록하는 곳이 없어서 1로 하드코딩

                // 금액계산
                var optionPrice = data['optionService' + optionIndex] * optionPetList.length;
                optionTotalPrice += optionPrice;
                sForm = sForm.replace('{service_price}', comma(optionPrice));

                // 서비스옵션 n개만큼 계속 append
                $('.content-option-warp').append(sForm);

            }


        }

        // 픽업서비스 출력 (미선택시 미출력)
        if($('#pickupService').val() != '0') {
            var nPickupCount = parseInt($('#pickupService').val());
            var pForm = commonUtils.form.serviceForm;

            pForm = pForm.replace('{pet_class}', 'hide');
            pForm = pForm.replace('{service_name}', '픽업서비스').replace('{service_count}', $('#pickupService option:selected').text());

            var pOptionPrice = parseInt(data[keyData.pickupPrice[nPickupCount-1]]);
            optionTotalPrice += pOptionPrice;
            pForm = pForm.replace('{service_price}', comma(pOptionPrice));


            $('.content-option-warp').append(pForm);
        }

        // 모든 서비스옵션 가격결과출력을 끝낸 뒤 총 합계금액을 출력
        $('.content-total').find('small').text(comma(resultDiscountPrice + optionTotalPrice) + ' 원');
        $('.content-main form .content-total input[name="total_price"]').val(resultDiscountPrice + optionTotalPrice); //hidden으로 값보내기

    };

    // 미리 준비해놓은 폼이 준비되어있는지 확인
    if(commonUtils.form.serviceForm == undefined) {

        // 폼이 없을경우 petsitter.service.form.php 에서 서비스옵션 가격결과폼을 가져와서
        // commonUtils.form.serviceForm 전역변수에 넣어놓고 두고두고 쓸 수 있도록 준비
        $.get('../layouts/form/petsitter.service.form.php', function(form) {
            commonUtils.form.serviceForm = form;

            // 폼을 불러온 뒤에 doService()를 실행
            doService();
        });
    } else {

        // 위에 있는 코드가 한번 불러와서 이미 폼이 있으면 doService() 함수를 바로 실행
        doService();
    }


};


function reloadNoti() {
    $.ajax({
        type:"POST",
        url: "../php/check-noti.php",
        success:function(data){
            var arg = $.parseJSON(data);

            var innerHtml = "";
            for (var i=0; i<arg.length; i++){
                innerHtml += "<a href='"+arg[i].linkURL+"'>";
                innerHtml += "<div class='header_usermeun'>";
                innerHtml += arg[i].notiBody;
                innerHtml += "</div></a>";
            }

            $('.noti-list').html(innerHtml );
        },
        error:function(e){
            var innerHtml =
                "<a href='javascript:void(0)'>" +
                "<div class='header_usermeun'>" +
                "현재 알림이 없습니다." +
                "</div>" +
                "</a>";
            $('.noti-list').html(innerHtml );
        }
    });
}

function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}


$(document).ready(function (e) {
    // TODO 일정 시간마다 Refresh
    reloadNoti();
});