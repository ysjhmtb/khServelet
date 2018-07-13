<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/join.css">
<style>
#container{
	min-height: 900px; 
	padding-top: 52px; 
	margin-top:30px;
	margin-left:80px;
	font-size: 150%;
	font-weight: bold;
	position: relative;
    width: 768px;
    min-width: 460px;
    margin: 0 auto;
}
#content{
	display:block;
}
.join_content{
	width:500px;
	margin:auto;
}
form{
	margin:0;
	padding:0;
	display:block;
}
li{
	width:500px;
	margin-left:auto;
	margin-right:auto;
	list-style:none;
	display:inline-block;
}
div.line{
	width:135px;
	list-style:none;
	display:inline-block;
}
form{
	margin:0;
	padding:0;
}
#pat{
	text-align:center;
	width:500px;
	margin-left:auto;
	margin-right:auto;
	background:#e52770;
}
.jender{
	position: relative;
    z-index: 10;
    display: block;
    float: left;
    width: 49.8%;
    height: 31px;
    border-right: solid 1px #dcdcdc;
}
#age{
	display:inline-block;
	width:80px;
}
#addr{
	display:inline-block;
	width:100px;
}
#yy{
	
}
#styl{
	width:500px;
	height:30px;
	background:yellow;
}
#patIde{
}
#patId{
}
#cc{
}
#test{
	height:40px;
}
#ul{
	padding-left:0;
}
#ul li{
	padding-left:0;
}
div{
	margin-top:-3px;
}

</style>
<!--정규표현식
	아이디 정규표현식
	<!--
	  var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
      if( !idReg.test( $("input[name=uid]").val() ) ) {
          alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
          return;
      }else{
    	  alert("Error");
      }
      
-->
<script>
<!--다음 우편번호api-->
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('sample6_address').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('sample6_address2').focus();
        }
    }).open();
}
 

$(function(){
	var pat = $("#patId");
	pat.focus(function(){
		//pat.val("포커스 얻음");
	});
	pat.blur(function(){
		//pat.val("포커스 잃음");
	});
	//$('input[name="sex"]').val();
});

 
 function validate(){
	if($("#patpassword").val() != $("#patpasswordcheck").val()){
		$("#passChkSpan").text("입력하신 비밀번호가 일치하지 않습니다.");
		$("#patpasswordcheck").focus();
		return false;
	}
	
	 var patIdVal = $("#patId").val();

	  var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	  if (patIdVal.match(regExp) != null) {
		    alert('Good!');
		  }
		  else {
		    alert('Error');
		  }
	
     var passVal = $("#patpassword").val();
     var regex = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
     
     if(passVal.match(regex) != null){
   	  alert("패스워드 사용가능");
     }else{
   	  alert("패스워드를 다시 확인하십시오.");
     }
    
     var birVal = $("#yy").val();
     if(!birVal==""&&birVal!=null){
   	  alert("년 입력확인");
     }else{
   	  alert("년 입력안함");
     }
     
     var mmVal = $("#mm").val();
     if(!mmVal==""&&mmVal!=null){
   	  alert("월 입력확인");
     }else{
   	  alert("월 입력안함");
     }
     
     var ddVal = $("#dd").val();
     if(!ddVal==""&&ddVal!=null){
   	  alert("일 입력확인");
     }else{
   	  alert("일 입력안함");
     }
     
     var patnameVal = $("#patname").val();
     if(!patnameVal==""&&patnameVal!=null){
   	  alert("이름 입력확인");
     }else{
   	  alert("이름 입력안함");
     }
     
     var patphoneVal = $("#patphone").val();
     if(!patphoneVal==""&&patphoneVal!=null){
   	  alert("전화번호 입력확인");
     }else{
   	  alert("전화번호 입력안함");
     }
     
     var sample6_postcodeVal = $("#sample6_postcode").val();
     if(!sample6_postcodeVal==""&&sample6_postcodeVal!=null){
   	  alert("우편번호 입력확인");
     }else{
   	  alert("우편번호 입력안함");
     }
     
     var sample6_address2Val = $("#sample6_address2").val();
     if(!sample6_address2Val==""&&sample6_address2Val!=null){
   	  alert("상세주소 입력확인");
     }else{
   	  alert("상세주소 입력안함");
     }
	
	return true;
} 

 function pat(){
	  $("#joinForm").submit();
} 

</script>
</head>
<body>
	<!-- Header -->
	<%@include file="../common/header.jsp" %>
	<div id = "container">
	<div id = "content">
	<div class = "join_content">
	<div class="join_form">
			<form id = "joinForm" method= "post" action = "/ptp/join.do" onsubmit = "return validate();">
				<div id="ul">
					<div class="ide"><div id="patIde"><input type="text"  id="patId" name="uid" placeholder="아이디"/></div></div>
					<div><div id="pass"><input type="password" name="upass" maxlength="10" id="patpassword" placeholder="비밀번호"/></div></div>
					<div><div id="passCheck"><input type="password" name="upassCheck" maxlength="10" id="patpasswordcheck" placeholder="비밀번호 확인"/></div><br></div>
					
					<div><div id="patName"><input type="text" maxlength="15" name="patName" id="patname" placeholder="이름"/></div></div>
					<div><div id="jenderCheck">
					<span class="jender">
					<input type="radio" id="man" checked name="sex" value="0" ><label id="manLb" for="man">남자 </label>
					</span>
					<span class="jender">
					<input type="radio" id="woman" name="sex" value="1" >
					<label id="womanLb" for="woman">여자 </label>
					</span>
					</div>
					</div>
					<div><div id="patPhone"><input type="text" maxlength="13" name="patPhone" id="patphone" placeholder="전화번호"/></div><br></div>
					
					<div id="age" class="line"><input type="text" id="patage" name="patAge" placeholder="생일" readonly/></div>
					<div class="line"><input type="text" id="yy" name="yy" maxlength="4" value="" onfocus="toggleLabel('yyLb','yy','in');" onblur="toggleLabel('yyLb','yy','out');checkBirthday('check')" placeholder="년(4자)" class="int"></div>
					<div class="line"><span>
					<select id="mm" name="mm" title="월"class="sel" onchange="checkBirthday('check')">
											<option value="">월</option>
										  	 			<option value="1">1</option>
										  	 			<option value="2">2</option>
										  	 			<option value="3">3</option>
										  	 			<option value="4">4</option>
										  	 			<option value="5">5</option>
										  	 			<option value="6">6</option>
										  	 			<option value="7">7</option>
										  	 			<option value="8">8</option>
										  	 			<option value="9">9</option>
										  	 			<option value="10">10</option>
										  	 			<option value="11">11</option>
										  	 			<option value="12">12</option>
										</select></span></div>
					<div class="line"><span>
					<input type="text" id="dd" name="dd" maxlength="2" value="" onfocus="toggleLabel('ddLb','dd','in');" onblur="toggleLabel('ddLb','dd','out');checkBirthday('check')" placeholder="일" class="int">
					</span>			
					</div>
					<div id="addr"><input type="text" id="sample6_postcode" name="sample6_postcode" placeholder="우편번호"></div>
					<div id="addr cc"><input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"></div>
					<div><input type="text" id="sample6_address" name="sample6_address" placeholder="주소"></div>
					<div><input type="text" id="sample6_address2" name="sample6_address2" placeholder="상세주소"></div>
				</div>
				<br>
				<div id="pat" onclick="pat();">가입하기</div>
			</form>
			</div>
	</div>
	</div>
	</div>
	<!-- Footer -->
	<%@include file="../common/footer.jsp" %>
</body>
</html>