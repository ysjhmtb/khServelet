/**
 * Created by jin on 2015. 12. 26..
 */

var scheduleUtils;

(typeof global == 'undefined' ? window : global).scheduleUtils = scheduleUtils = {

    common : {},
    constants : {},
    value : {},
    data : {},
    net : {},
    draw : {},
    func : {},
    modal : {},
    view : {}
};


scheduleUtils.constants.getScheduleList = '/schedule.php';
scheduleUtils.constants.addSchedule = '/schedule.php';
scheduleUtils.constants.updateDefaultSchedule = '/schedule.php';
scheduleUtils.constants.removeSchedule = '/schedule.php';

scheduleUtils.common.ajax = function(data) {

    if(data._method == undefined) {
        data._method = "GET";
    } else {

        if(data.params != undefined) {
            data.params._method = data._method;
        }

        data._method = "POST";
    }

    $.ajax({
        type : data._method,
        url : '../php' + data.url,
        data : data.params,
        dataType : 'json',
        success : function(res) {

            if(data.success != undefined) {
                data.success(res);
            }

        },
        error : function(err) {

            if(data.error != undefined) {
                data.error(err);
            }

        }
    });

};

scheduleUtils.net.getScheduleList = function(data) {

    scheduleUtils.common.ajax({
        _method : "GET",
        url : scheduleUtils.constants.getScheduleList,
        params : data.params,
        success : data.success,
        error : data.error
    });
};

scheduleUtils.net.addSchedule = function(data) {

    scheduleUtils.common.ajax({
        _method : "PUT",
        url : scheduleUtils.constants.addSchedule,
        params : data.params,
        success : data.success,
        error : data.error
    });

};

scheduleUtils.net.removeSchedule = function(data) {

    scheduleUtils.common.ajax({
        _method : "DELETE",
        url : scheduleUtils.constants.removeSchedule,
        params : data.params,
        success : data.success,
        error : data.error
    });

};

scheduleUtils.net.updateDefaultSchedule = function(data) {

    scheduleUtils.common.ajax({
        _method : "POST",
        url : scheduleUtils.constants.updateDefaultSchedule,
        params : data.params,
        success : data.success,
        error : data.error
    });

};

scheduleUtils.func.addSchedule = function() {

    var scheduleData = {
        memberId : $('#ms-d-id').val(),
        memo : $('#ms-d-memo').val(),
        start_date : $('#ms-d-start').val(),
        end_date : $('#ms-d-end').val()
    };

    if(scheduleData.memberId.length == 0) {
        alert('정상적인 경로가 아닙니다. 잠시 후에 다시 시도해주세요.');
        return;
    }

    if(scheduleData.memo.length == 0) {
        alert('스케쥴메모를 입력해주세요.');
        return;
    }

    if(scheduleData.start_date.length == 0 || scheduleData.end_date.length == 0) {
        alert('시작날짜와 종료날짜를 입력해주세요.');
        return;
    }

    commonUtils.func.loading({
        show:true
    });

    scheduleUtils.net.addSchedule({
        params : scheduleData,
        success : function(res) {

            commonUtils.func.loading({
                show:false
            });

            $('#ms-d-memo').val('');
            $('#ms-d-start').val('');
            $('#ms-d-end').val('');

            var keyList = ['memo', 'start_date', 'end_date'];


            var tdForm = '<td>{value}</td>';
            var tdList = tdForm.replace('{value}', $('#ms-d-list').children().length+1);

            for(var i in keyList) {
                var key = keyList[i];

                tdList = tdList + tdForm.replace('{value}', scheduleData[key]);

            }
            tdList = tdList + tdForm.replace('{value}', '<a href="#!" onclick="scheduleUtils.func.removeSchedule({id}, this)">삭제하기</a>'.replace('{id}', res.schedule_id));

            $('#ms-d-list').append('<tr>{td}</tr>'.replace('{td}', tdList));

            var maxLength = $('#ms-d-list').children().length;

            for(var i=0; i<maxLength; i++) {
                var $item = $('#ms-d-list').children().eq(i).find('td').eq(0);

                $item.text(i+1);
            }

        },
        error : function(err) {

            commonUtils.func.loading({
                show:false
            });

            console.log('error', err);

        }
    });

};

scheduleUtils.func.removeSchedule = function(id, self) {

    if(!confirm('선택한 일정을 삭제하시겠습니까?')) {
        return;
    }

    $(self).closest('tr').remove();

    var maxLength = $('#ms-d-list').children().length;
    for(var i=0; i<maxLength; i++) {
        var $item = $('#ms-d-list').children().eq(i).find('td').eq(0);

        $item.text(i+1);
    }

    scheduleUtils.net.removeSchedule({
        params : {
            scheduleId : id
        },
        success : function(res) {


        },
        error : function(err) {

        }
    });

};

scheduleUtils.func.saveDefaultSchedule = function() {

    var maxLength = $('input[type="checkbox"]').length;

    var dsParams = {
        memberId : $('#ms-d-id').val()
    };
    for(var i=0; i<maxLength; i++) {
        var $item = $('input[type="checkbox"]').eq(i);

        dsParams[$item.data('key')] = $item.is(':checked')?'true':'false';

    }

    dsParams.start_time = $('select').eq(0).val();
    dsParams.end_time = $('select').eq(1).val();
    dsParams.type = $("[name='type']").val();

    commonUtils.func.loading({
        show:true
    });

    scheduleUtils.net.updateDefaultSchedule({
        params : dsParams,
        success : function(res) {


            commonUtils.func.loading({
                show:false
            });

            alert("정상적으로 저장되었습니다.");

            //type이 호스트가 아니면 이동
            if(dsParams.type == 0){
             location.href= '../page/petsitter-request-end.php'
             }
        },
        error : function(err) {
            commonUtils.func.loading({
                show:false
            });
            alert('네트워크오류로 저장에 실패했습니다. \n잠시후에 다시 시도해주세요.');
        }
    });

};



//---------------------------------------------------------

scheduleUtils.func.getScheduleList = function(data) {

    scheduleUtils.net.getScheduleList({
        params : {
            memberId : data.memberId
        },
        success : function(res) {

            if(data.next != undefined) {
                data.next(res);
            }

        },
        error : function(err) {

        }
    });
};