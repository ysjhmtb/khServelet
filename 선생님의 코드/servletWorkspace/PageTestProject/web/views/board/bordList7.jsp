<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/common/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/common/jquery-ui-1.11.4/jquery-ui.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/bower_components/select2/dist/js/select2.min.js"></script>

	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/common/common.js?v=1"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/common/popup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/dog_common.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/slick-carousel/slick/slick.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/slick-lightbox/dist/slick-lightbox.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/jquery-sticky/jquery.sticky.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/moment/min/moment.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/moment/locale/ko.js"></script>







<style>


.filter-tabs {
	
    padding: 0;
    margin: 0 auto;
    clear: both;
    position: relative;
    text-align: center;
    
}

.states-tabs .visible-xs-block {
  background-color: #fff;
  padding: 15px 0 20px;
  border-bottom: solid 1px #ccc;
}
.states-tabs .visible-xs-block .btn {
  margin: 0 auto !important;
  padding: 9px 20px 8px !important;
  border-radius: 5px;
  border-color: #fbbe53;
  color: #fac058;
  font-weight: 300;
}
.states-tabs .promotion {
  position: absolute;
  top: 14px;
  right: 18px;
  line-height: 16px;
  font-size: 12px;
  color: #61c2d9;
  font-weight: 400;
  vertical-align: middle;
}
.states-tabs .promotion:hover {
  color: #FAC058;
}
.states-tabs .promotion .badge {
  margin-top: -2px;
  margin-right: 5px;
  font-size: 9px;
  background-color: #70c7dc;
  color: #fef187;
  font-weight: 300;
}


  .states-tabs {
		position: fixed;
		top: 50px;
		left: -190px;
    z-index: 97;
	}
	.states-tabs .nav-tabs {
		margin-top: 0px;
		border: none;
		border-bottom: solid 1px #ccc;
		will-change: margin-top;
		transition: margin-top 200ms linear;
		z-index: 5;
		background-color: white;
	}
	.states-tabs .nav-tabs.headroom--unpinned {
		margin-top: -50px;
	}
	.visible-banner-top .states-tabs .nav-tabs,
	.visible-banner-top .states-tabs .dropdown-menu {
		margin-top: 60px;
	}
	.visible-banner-top .states-tabs .nav-tabs.headroom--unpinned {
		margin-top: 0px;
	}
	.states-tabs .nav-tabs>li {
		width: 25%;
	}
	.states-tabs .nav-tabs>li>a {
		padding: 15px 0 14px;
	}
	.states-tabs .nav-tabs>li.open>a:after, .states-tabs .nav-tabs>li.open>a:before {
		bottom: 0;
	}
	.states-tabs .dropdown-menu {
		width: 100%;
	}
	.states-tabs .dropdown-menu li {
		width: 33.3333%;
	}
	.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label {
		width: 100%;
	}
	.states-tabs .btn {
		display: block;
		margin: 20px auto 5px !important;
	}
	.states-tabs .btn.btn-link {
		margin-top: 0 !important;
	}
	.states-tabs .close {
		margin: -35px 0 -10px 0 !important;
		padding: 0 5px !important;
		font-size: 40px;
    font-weight: 100;
	}
	
	
	
.states-tabs .nav-tabs {
	min-height: 41px;
	min-width: 1000px;
	margin-top: 35px;
	border: solid 1px #fbbe53;
	background-color: #f5f5f5;
	font-size: 13px;
}
.states-tabs .nav-tabs>li {
	width: 120px;
	position: static;
	margin-bottom: 0;
}
.states-tabs .nav-tabs>li>a,
.states-tabs .nav-tabs>li>a:focus,
.states-tabs .nav-tabs>li>a:hover {
	margin: 0;
	border-radius: 0;
	border: none;
	border-right: solid 1px #ededed;
	color: #699769;
}
.states-tabs .nav-tabs>li>a>span {
	margin-left: 5px;
	color: #fac058;
	font-weight: bold;
}
.states-tabs .nav-tabs>li.active>a,
.states-tabs .nav-tabs>li.active>a:focus,
.states-tabs .nav-tabs>li.active>a:hover,
.states-tabs .nav-tabs>li.open>a,
.states-tabs .nav-tabs>li.open>a:focus,
.states-tabs .nav-tabs>li.open>a:hover,
.states-tabs .nav-tabs>li.active>a>span,
.states-tabs .nav-tabs>li.open>a>span {
	background-color: #fac058;
	color: #fff;
}
.states-tabs .nav-tabs>li.open>a {
	position: relative;
}
.states-tabs .nav-tabs>li.open>a:after, .states-tabs .nav-tabs>li.open>a:before {
	bottom: -7px;
	left: 50%;
	border: solid transparent;
	content: " ";
	height: 0;
	width: 0;
	position: absolute;
	pointer-events: none;
	z-index: 1001;
}
.states-tabs .nav-tabs>li.open>a:after {
	border-color: rgba(255, 255, 255, 0);
	border-bottom-color: #fff;
	border-width: 6px;
	margin-left: -6px;
}
.states-tabs .nav-tabs>li.open>a:before {
	border-color: rgba(249, 194, 93, 0);
	border-bottom-color: #f9c25d;
	border-width: 7px;
	margin-left: -7px;
}
.states-tabs .dropdown-menu {
	width: 875px;
	padding: 8px 10px 15px 20px;
	top: 47px;
	border-radius: 0;
	border: solid 1px #f9c25d;
	font-size: 13px;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label {
	width: 105px;
	margin-right: 0 !important;
	padding: 10px 0 10px 25px;
	color: #696969;
	font-weight: normal;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label:before,
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label:after {
	top: 11px;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox]:checked + label {
	font-weight: bold;
}
.states-tabs .btn {
	margin-top: 15px !important;
	padding: 8px 15px 7px !important;
	color: #fff;
	font-weight: 400;
}
.states-tabs .btn-mint {
	width: 90px;
}
.states-tabs .btn-link {
	color: #696969;
	text-decoration: underline;
}


.header-member + .dropdown-menu {
	min-width: auto;
	top: 85%;
	left: 162px;
}
.sitter-approved .header-member + .dropdown-menu {
	left: 205px;
}
.visible-block-sitters-only {
	display: none;
}
.sitter-approved .visible-block-sitters-only {
	display: block;
}
.header-member + .dropdown-menu a {
	color: #868686;
    padding: 0 20px;
    line-height: 230%;
	font-weight: normal;
}
.header-menu-inner .dropdown-menu:before {
  position: absolute;
  top: -7px;
  left: 60%;
  display: inline-block;
  border-right: 7px solid transparent;
  border-bottom: 7px solid #ccc;
  border-left: 7px solid transparent;
  border-bottom-color: rgba(0, 0, 0, 0.2);
  content: '';
}
.header-menu-inner .dropdown-menu:after {
  position: absolute;
  top: -6px;
  left: 61%;
  display: inline-block;
  border-right: 6px solid transparent;
  border-bottom: 6px solid #ffffff;
  border-left: 6px solid transparent;
  content: '';
}


.header-message .dropdown-menu {
	width: 450px;
	padding: 0;
	left: -240px;
	border-radius: 0;
}
.header-message .dropdown-menu:before {
	left: 272px;
}
.header-message .dropdown-menu:after {
	left: 273px;
}
.header-message .dropdown-menu li {
	border-top: solid 1px #dcdcdc;
}
.header-message .dropdown-menu li:first-child {
	border-top: none;
}
.header-message .dropdown-menu a {
	padding: 20px 15px;
	position: relative;
	color: #7d7d7d;
}
.header-message .dropdown-menu .profile-photo {
	width: 50px;
	height: 50px;
	position: absolute;
	top: 20px;
	left: 15px;
	border-radius: 50%;
	border: solid 1px #dcdcdc;
	background-size: cover;
    background-position: center 50%;
    background-repeat: no-repeat;
}
.header-message .dropdown-menu dl {
	margin: 5px 0 2px 60px;
}
.header-message .dropdown-menu dt label {
	font-weight: 700;
}
.header-menu .header-menu-inner .header-message .dropdown-menu dt span {
	margin-right: 5px;
	height: 20px;
	font-size: 12px;
	font-weight: 500;
}
.header-message .dropdown-menu dd {
	font-size: 12px;
	font-weight: normal;
	text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
}
.header-message .dropdown-menu .no-content {
	line-height: 80px;
}

.states-tabs .dropdown-menu {
	width: 875px;
	padding: 8px 10px 15px 20px;
	top: 47px;
	border-radius: 0;
	border: solid 1px #f9c25d;
	font-size: 13px;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label {
	width: 105px;
	margin-right: 0 !important;
	padding: 10px 0 10px 25px;
	color: #696969;
	font-weight: normal;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label:before,
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label:after {
	top: 11px;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox]:checked + label {
	font-weight: bold;
}

.visible-banner-top .states-tabs .dropdown-menu {
		margin-top: 60px;
	}

.states-tabs .dropdown-menu {
		width: 100%;
	}
	.states-tabs .dropdown-menu li {
		width: 33.3333%;
	}
	.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label {
		width: 100%;
	}
	
	.header-menu .header-menu-inner .header-message .dropdown-menu dt span {
		margin: 2px 0 3px 0;
	}
	.header-message .dropdown-menu {
		width: 100%;
		margin-top: -1px;
		left: 0;
	}
	.header-message .dropdown-menu:before, .header-message .dropdown-menu:after {
		content: none;
	}
	.header-message .dropdown-menu a {
		padding: 20px 12px;
	}
	.header-message .dropdown-menu .profile-photo {
		left: 12px;
	}
	.header-message .dropdown-menu dl {
		margin: 3px 0 2px 60px;
	}
	.header-message .dropdown-menu dt label {
		font-size: 16px
	}
	.header-message .dropdown-menu dd {
		font-size: 14px
	}
	
	
	.info-tabs{
	
	border: solid 1px #dcdcdc;
	min-width:1000px;
	height:130px;
	left:35px;
	
	
	}
	
	
	.fix{
	height: 100%;
	width:150px;
	float:left;
	font-size: 15px;
	border: solid 1px #dcdcdc;
	padding: 15px;
	
	}
	.fix-select{
	width: 130px;
	font-size: 13px;
	
	}
	
	
	.fix2{
	height: 130px;
	width:400px;
	border: solid 1px #dcdcdc;
	float:right;
	}




</style>



</head>
<body>

<%@include file="../common/header.jsp" %>

<div class="filter-tabs">
<div class="states-tabs inner">
      <ul class="nav nav-tabs" role="tablist">
        <li role="presentation"><a href="">전체<span>277</span></a></li>
       <li role="presentation"><a href="">서울<span>277</span></a></li>
       <li role="presentation"><a href="">경기<span>277</span></a></li>
       <li role="presentation"><a href="">인천<span>277</span></a></li>
      <li role="presentation" class="dropdown"><a href="" id="stateTabDrop0" data-toggle="dropdown" aria-controls="stateTabDrop1-contents" class="dropdown-toggle">그 외 지역<span>111</span></a>
      <div id="stateTabDrop0-contents" role="menu" aria-controls="stateTabDrop0" class="dropdown-menu">
      <ul class="clearfix">
      <li class="pull-left"><input type="checkbox" name="states[]" id="state10" class="checkbox" value="10"><label for="state10">부산</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state59" class="checkbox" value="59"><label for="state59">대구</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state35" class="checkbox" value="35"><label for="state35">광주</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state24" class="checkbox" value="24"><label for="state24">대전</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state51" class="checkbox" value="51"><label for="state51">울산</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state43" class="checkbox" value="43"><label for="state43">세종</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state49" class="checkbox" value="49"><label for="state49">강원</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state31" class="checkbox" value="31"><label for="state31">경남</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state20" class="checkbox" value="20"><label for="state20">경북</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state13" class="checkbox" value="13"><label for="state13">전남</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state26" class="checkbox" value="26"><label for="state26">전북</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state17" class="checkbox" value="17"><label for="state17">충남</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state18" class="checkbox" value="18"><label for="state18">충북</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state53" class="checkbox" value="53"><label for="state53">제주</label></li></ul>
      <button type="button" data-loading="검색 중..." class="btn btn-mint">확인</button><button type="button" class="btn btn-link">선택 초기화</button>
      <button type="button" aria-label="Close" class="close visible-xs-block"><span aria-hidden="true">×</span></button>
      </div></li></ul>
    
			
        <!-- 서브 목록 이벤트 바로가기 링크 -->
        <!-- <a href="/event/Model_dog" class="hidden-xs promotion" target="_self">
				<span class="badge">이벤트</span>도그메이트의 모델견이 되어주세요! -->
			
	</div>
	<div class="info-tabs inner">
	
	<div class="fix">
     <dt>서비스</dt>
	<select class="fix-select" >
    <option class=fix-option; value="all">모든 서비스</option>
    <option class=fix-option; value="학생">데이케어</option>
    <option class=fix-option; value="회사원">24시간 돌봄</option>
	</select>
	</div>
	<div class="fix">
	<dt>위탁 동물 종류</dt>
	<select class="fix-select" >
    <option class=fix-option; value="all">모든 반려동물</option>
    <option class=fix-option; value="학생">강아지</option>
    <option class=fix-option; value="회사원">고양이</option>
    <option class=fix-option; value="기타">기타</option>
	</select>
	</div>
	<div class="fix">
	<dt>펫시터 등급</dt>
	<select class="fix-select" >
    <option class=fix-option; value="all">모든 등급</option>
    <option class=fix-option; value="학생">우수회원</option>
    <option class=fix-option; value="회사원">일반회원</option>
	</select>
	</div>
	
	<div class="fix2">
	<span class="range_input"><input type="text" title="최소가격 입력" id="min_p" value="">원</span>
	<span class="range_at">~</span>
	<span class="range_input"><input type="text" title="최대가격 입력" id="max_p" value="">원</span>
	
	
	<input type="submit" value="펫시터 검색" class="submit1" style="display: inherit; height:58px; padding-top:10px; margin:auto; margin-top:19px;">
	</div>
	</div>
	</div>
	
	


</body>
</html>