<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="canonical" href="https://www.dogmate.co.kr/reserve/search" />
<link rel="shortcut icon" href="/static/img/common/favicon.ico" />
<link href="/static/js/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="/static/js/bower_components/select2/dist/css/select2.min.css" rel="stylesheet" />
<link href="/static/js/bower_components/bootstrap-fileinput/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/static/css/common/reset.css" />
<link rel='stylesheet' type='text/css' href='/static/css/common/datepicker.css' />
<link rel="stylesheet" type="text/css" href="/static/css/common/popup-bnr.css" />
<link rel="stylesheet" type="text/css" href="/static/css/common/common.css?v=12" />
<link rel="stylesheet" type="text/css" href="/static/css/common/common_sp.css?v=9" />
<!-- <link rel="stylesheet" type="text/css" href="/static/css/slide/jquery.fancybox-1.3.4.css"/> -->
<!-- 2016.02.17 ara start -->
<link rel='stylesheet' type='text/css' href='/static/js/bower_components/slick-carousel/slick/slick.css'>
<link rel='stylesheet' type='text/css' href='/static/js/bower_components/slick-carousel/slick/slick-theme.css'>
<link rel='stylesheet' type='text/css' href='/static/js/bower_components/bootstrap-select/dist/css/bootstrap-select.min.css'>
<link rel='stylesheet' type='text/css' href='/static/css/search.css?v=9'>
<title>예약하기</title>
	<style>
	.filters inner{
		display:inline-block;
		width:350px;
		height:350px;
		
	
	}
	
	.bootstrap-select.btn-group .dropdown-toggle .filter-option {
    display: inline-block;
    overflow: hidden;
    width: 100%;
    text-align: left;
}

.filters .filter-option {
    padding: 10px 12px 9px;
    color: #696969;
    line-height: 1;
}
	.pull-left {
    float: left!important;
}

.btn-default {
    color: #333;
    background-color: #fff;
    border-color: #ccc;
}
	
	.btn {
    display: inline-block;
    padding: 6px 12px;
    margin-bottom: 0;
    font-size: 14px;
    font-weight: 400;
    line-height: 1.42857143;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    -ms-touch-action: manipulation;
    touch-action: manipulation;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    background-image: none;
    border: 1px solid transparent;
    border-radius: 4px;
}
button, select {
    text-transform: none;
}

.filters .col-tags .btn {
    padding: 7px 0 6px;
    border-radius: 5px;
    background-color: #dcdcdc;
    color: #fff;
}
.btn-group>.btn:first-child {
    margin-left: 0;
}
.btn-group-vertical>.btn, .btn-group>.btn {
    position: relative;
    float: left;
}






   </style>

<%@include file="../common/header.jsp" %>


  <div class="main-wrap no-profile">
    <div class="states-tabs inner">
      <ul class="nav nav-tabs text-center headroom headroom--top headroom--not-bottom" role="tablist">
      <li role="presentation"><a href="">전체<span>277</span></a></li>
      <li role="presentation" class="dropdown"><a href="" id="stateTabDrop0" data-toggle="dropdown" aria-controls="stateTabDrop0-contents" class="dropdown-toggle">서울<span>150</span></a>
      <div id="stateTabDrop0-contents" role="menu" aria-controls="stateTabDrop0" class="dropdown-menu">
      <ul class="clearfix">
      <li class="pull-left"><input type="checkbox" name="states[]" id="state8" class="checkbox" value="8"><label for="state8">강남구 (9)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state16" class="checkbox" value="16"><label for="state16">강동구 (9)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state57" class="checkbox" value="57"><label for="state57">강북구 (4)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state37" class="checkbox" value="37"><label for="state37">강서구 (7)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state7" class="checkbox" value="7"><label for="state7">관악구 (6)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state41" class="checkbox" value="41"><label for="state41">광진구 (2)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state15" class="checkbox" value="15"><label for="state15">구로구 (3)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state50" class="checkbox" value="50"><label for="state50">금천구 (5)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state33" class="checkbox" value="33"><label for="state33">노원구 (4)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state32" class="checkbox" value="32"><label for="state32">도봉구 (2)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state39" class="checkbox" value="39"><label for="state39">동대문구 (7)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state23" class="checkbox" value="23"><label for="state23">동작구 (8)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state19" class="checkbox" value="19"><label for="state19">마포구 (9)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state22" class="checkbox" value="22"><label for="state22">서대문구 (5)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state6" class="checkbox" value="6"><label for="state6">서초구 (11)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state27" class="checkbox" value="27"><label for="state27">성동구 (4)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state12" class="checkbox" value="12"><label for="state12">성북구 (7)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state34" class="checkbox" value="34"><label for="state34">송파구 (9)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state40" class="checkbox" value="40"><label for="state40">양천구 (5)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state45" class="checkbox" value="45"><label for="state45">영등포구 (12)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state9" class="checkbox" value="9"><label for="state9">용산구 (9)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state28" class="checkbox" value="28"><label for="state28">은평구 (8)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state25" class="checkbox" value="25"><label for="state25">종로구 (3)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state42" class="checkbox" value="42"><label for="state42">중구 (1)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state54" class="checkbox" value="54"><label for="state54">중랑구 (1)</label></li>
      </ul><button type="button" data-loading="검색 중..." class="btn btn-mint">확인</button><button type="button" class="btn btn-link">선택 초기화</button>
      <button type="button" aria-label="Close" class="close visible-xs-block"><span aria-hidden="true">×</span></button>
      </div></li>
      <li role="presentation" class="dropdown"><a href="" id="stateTabDrop1" data-toggle="dropdown" aria-controls="stateTabDrop1-contents" class="dropdown-toggle">경기<span>111</span></a>
      <div id="stateTabDrop1-contents" role="menu" aria-controls="stateTabDrop1" class="dropdown-menu">
      <ul class="clearfix">
      <li class="pull-left"><input type="checkbox" name="states[]" id="state10" class="checkbox" value="10"><label for="state10">고양시 (16)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state59" class="checkbox" value="59"><label for="state59">과천시 (2)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state35" class="checkbox" value="35"><label for="state35">광명시 (2)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state24" class="checkbox" value="24"><label for="state24">광주시 (6)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state51" class="checkbox" value="51"><label for="state51">구리시 (3)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state43" class="checkbox" value="43"><label for="state43">군포시 (1)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state49" class="checkbox" value="49"><label for="state49">김포시 (4)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state31" class="checkbox" value="31"><label for="state31">남양주시 (11)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state20" class="checkbox" value="20"><label for="state20">부천시 (7)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state13" class="checkbox" value="13"><label for="state13">성남시 (17)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state26" class="checkbox" value="26"><label for="state26">수원시 (8)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state17" class="checkbox" value="17"><label for="state17">시흥시 (7)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state18" class="checkbox" value="18"><label for="state18">안산시 (2)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state53" class="checkbox" value="53"><label for="state53">안양시 (2)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state63" class="checkbox" value="63"><label for="state63">양주시 (1)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state21" class="checkbox" value="21"><label for="state21">용인시 (8)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state62" class="checkbox" value="62"><label for="state62">의왕시 (1)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state11" class="checkbox" value="11"><label for="state11">의정부시 (1)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state58" class="checkbox" value="58"><label for="state58">파주시 (2)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state44" class="checkbox" value="44"><label for="state44">평택시 (5)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state46" class="checkbox" value="46"><label for="state46">하남시 (1)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state56" class="checkbox" value="56"><label for="state56">화성시 (4)</label></li></ul>
      <button type="button" data-loading="검색 중..." class="btn btn-mint">확인</button><button type="button" class="btn btn-link">선택 초기화</button>
      <button type="button" aria-label="Close" class="close visible-xs-block"><span aria-hidden="true">×</span></button></div></li>
      <li role="presentation" class="dropdown"><a href="" id="stateTabDrop2" data-toggle="dropdown" aria-controls="stateTabDrop2-contents" class="dropdown-toggle">인천<span>16</span></a>
      <div id="stateTabDrop2-contents" role="menu" aria-controls="stateTabDrop2" class="dropdown-menu">
      <ul class="clearfix">
      <li class="pull-left"><input type="checkbox" name="states[]" id="state36" class="checkbox" value="36"><label for="state36">계양구 (1)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state52" class="checkbox" value="52"><label for="state52">남구 (2)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state29" class="checkbox" value="29"><label for="state29">남동구 (2)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state38" class="checkbox" value="38"><label for="state38">부평구 (4)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state55" class="checkbox" value="55"><label for="state55">서구 (3)</label></li>
      <li class="pull-left"><input type="checkbox" name="states[]" id="state14" class="checkbox" value="14"><label for="state14">연수구 (4)</label></li></ul>
      <button type="button" data-loading="검색 중..." class="btn btn-mint">확인</button><button type="button" class="btn btn-link">선택 초기화</button>
      <button type="button" aria-label="Close" class="close visible-xs-block"><span aria-hidden="true">×</span></button>
      </div></li></ul>
      
      
			<div class="visible-xs-block text-center">
				<button type="button" class="btn btn-default">검색 필터 설정하기</button>
			</div>
        <!-- 서브 목록 이벤트 바로가기 링크 -->
        <!-- <a href="/event/Model_dog" class="hidden-xs promotion" target="_self">
				<span class="badge">이벤트</span>도그메이트의 모델견이 되어주세요! -->
			
			
    </div>
    <form class="filters inner">
			<div class="visible-xs-block text-center">
				<h3>검색 필터 설정하기</h3>
				<button type="button" aria-label="Close" class="close">
					<span aria-hidden="true">×</span></button>
			</div>
      <ul class="clearfix">
        <li class="col-type">
          <dl>
            <dt>서비스</dt>
            <dd>
              <div class="btn-group bootstrap-select selectpick hidden-xs" style="width: 120px;"><button type="button" class="btn dropdown-toggle btn-default" data-toggle="dropdown" role="button" title="24시간 돌봄"><span class="filter-option pull-left">24시간 돌봄</span>&nbsp;<span class="bs-caret"><span class="caret"></span></span></button><div class="dropdown-menu open" role="combobox"><ul class="dropdown-menu inner" role="listbox" aria-expanded="false"><li data-original-index="0" class="selected"><a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="true"><span class="text">24시간 돌봄</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="1"><a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="false"><span class="text">데이케어</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li></ul></div><select class="selectpick hidden-xs" name="service_type" data-width="120px" tabindex="-98">
                <option title="24시간 돌봄" value="1" selected="selected">24시간 돌봄</option>
                <option title="데이케어" value="2">데이케어</option>
              </select></div>
							<input type="radio" id="service-type-0" class="radiobox" name="service_type" value="1" checked="checked">
							<label for="service-type-0" class="visible-xs-inline-block">24시간 돌봄</label>
							<input type="radio" id="service-type-1" class="radiobox" name="service_type" value="2">
							<label for="service-type-1" class="visible-xs-inline-block">Day Care</label>
            </dd>
          </dl>
        </li>
        <li class="col-dates">
          <dl>
            <dt>예약일을 알려주세요!</dt>
            <dd class="clearfix text-center">
              <input type="text" class="pull-left hasDatepicker" placeholder="시작 날짜" readonly="readonly" value="" id="dp1529583174374">
              <span>&gt;</span>
              <input type="text" class="pull-right hasDatepicker" placeholder="마침 날짜" readonly="readonly" value="" id="dp1529583174375">
            </dd>
          </dl>
        </li>
        <li class="col-age">
          <dl>
            <dt>반려견 나이</dt>
            <dd>
              <div class="btn-group bootstrap-select show-tick selectpick hidden-xs" style="width: 130px;"><button type="button" class="btn dropdown-toggle btn-default" data-toggle="dropdown" role="button" title="강아지 외 1개" aria-expanded="false"><span class="filter-option pull-left">강아지 외 1개</span>&nbsp;<span class="bs-caret"><span class="caret"></span></span></button><div class="dropdown-menu open" role="combobox" style="max-height: 559px; overflow: hidden; min-height: 0px;"><ul class="dropdown-menu inner" role="listbox" aria-expanded="false" style="max-height: 547px; overflow-y: auto; min-height: 0px;"><li data-original-index="0" class="selected"><a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="true"><span class="text">강아지 (1살 이하)</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="1" class="selected"><a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="true"><span class="text">성견 (2~6살)</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="2" class=""><a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="false"><span class="text">노령견 (7살 이상)</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li></ul></div><select class="selectpick hidden-xs" multiple="" title="모든 연령" name="ages" data-width="130px" tabindex="-98">
                <option title="강아지" value="1311">강아지 (1살 이하)</option>
                <option title="성견" value="1312">성견 (2~6살)</option>
                <option title="노령견" value="1313">노령견 (7살 이상)</option>
              </select></div>
							<input type="checkbox" id="ages-0" class="checkbox" name="ages" value="1311">
							<label for="ages-0" class="visible-xs-block">강아지 (1살 이하)</label>
							<input type="checkbox" id="ages-1" class="checkbox" name="ages" value="1312">
							<label for="ages-1" class="visible-xs-block">성견 (2~6살)</label>
							<input type="checkbox" id="ages-2" class="checkbox" name="ages" value="1313">
							<label for="ages-2" class="visible-xs-block">노령견 (7살 이상)</label>
            </dd>
          </dl>
        </li>
        <li class="col-size">
          <dl>
            <dt>반려견 크기</dt>
            <dd>
              <div class="btn-group bootstrap-select show-tick selectpick hidden-xs" style="width: 130px;"><button type="button" class="btn dropdown-toggle btn-default" data-toggle="dropdown" role="button" title="중형견" aria-expanded="false"><span class="filter-option pull-left">중형견</span>&nbsp;<span class="bs-caret"><span class="caret"></span></span></button><div class="dropdown-menu open" role="combobox" style="max-height: 576px; overflow: hidden; min-height: 0px;"><ul class="dropdown-menu inner" role="listbox" aria-expanded="false" style="max-height: 564px; overflow-y: auto; min-height: 0px;"><li data-original-index="0"><a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="false"><span class="text">소형견 (0~4.9kg)</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="1" class="selected"><a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="true"><span class="text">중형견 (5~14.9kg)</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="2"><a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="false"><span class="text">대형견 (15kg 이상)</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li></ul></div><select class="selectpick hidden-xs" multiple="" title="모든 크기" name="sizes" data-width="130px" tabindex="-98">
                <option title="소형견" value="1321">소형견 (0~4.9kg)</option>
                <option title="중형견" value="1322" selected="selected">중형견 (5~14.9kg)</option>
                <option title="대형견" value="1323">대형견 (15kg 이상)</option>
              </select></div>
							<input type="checkbox" id="sizes-0" class="checkbox" name="sizes" value="1321">
							<label for="sizes-0" class="visible-xs-block">소형견 (0~4.9kg)</label>
							<input type="checkbox" id="sizes-1" class="checkbox" name="sizes" value="1322" checked="checked">
							<label for="sizes-1" class="visible-xs-block">중형견 (5~14.9kg)</label>
							<input type="checkbox" id="sizes-2" class="checkbox" name="sizes" value="1323">
							<label for="sizes-2" class="visible-xs-block">대형견 (15kg 이상)</label>
            </dd>
          </dl>
        </li>
        <li class="col-level pull-left">
          <dl>
            <dt>펫시터 등급</dt>
            <dd>
              <div class="btn-group bootstrap-select show-tick selectpick hidden-xs" style="width: 120px;"><button type="button" class="btn dropdown-toggle btn-default" data-toggle="dropdown" role="button" title="우수" aria-expanded="false"><span class="filter-option pull-left">우수</span>&nbsp;<span class="bs-caret"><span class="caret"></span></span></button><div class="dropdown-menu open" role="combobox" style="max-height: 576px; overflow: hidden; min-height: 0px;"><ul class="dropdown-menu inner" role="listbox" aria-expanded="false" style="max-height: 564px; overflow-y: auto; min-height: 0px;"><li data-original-index="0" class="selected"><a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="true"><span class="text">우수									펫시터</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="1"><a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="false"><span class="text">일반									펫시터</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="2"><a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="false"><span class="text">신규									펫시터</span><span class="glyphicon glyphicon-ok check-mark"></span></a></li></ul></div><select class="selectpick hidden-xs" multiple="" title="모든 등급" name="levels" data-width="120px" tabindex="-98">
                <option title="우수" value="1">우수									펫시터</option>
                <option title="일반" value="2">일반									펫시터</option>
                <option title="신규" value="3">신규									펫시터</option>
              </select></div>
							<input type="checkbox" id="levels-0" class="checkbox" name="levels" value="1">
							<label for="levels-0" class="visible-xs-block"><span class="circle gold"></span>
								우수 펫시터</label>
							<input type="checkbox" id="levels-1" class="checkbox" name="levels" value="2">
							<label for="levels-1" class="visible-xs-block"><span class="circle silver"></span>
								일반 펫시터</label>
							<input type="checkbox" id="levels-2" class="checkbox" name="levels" value="3">
							<label for="levels-2" class="visible-xs-block"><span class="circle bronze"></span>
								신규 펫시터</label>
            </dd>
          </dl>
        </li>
        <li class="col-btn">
          <dl>
            <dd><button class="btn hidden-xs">찾기</button>
							<button class="btn visible-xs-block">검색하기</button></dd>
          </dl>
        </li>
        <li class="col-tags">
          <dl>
            <dt>원하는 태그를 모두 선택해주세요!</dt>
            <dd>
							<div class="btn-group col-3" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="1201">아파트
							  </label>
							</div>
							<div class="btn-group col-2" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="has_house_yard">마당
							  </label>
							</div>
							<div class="btn-group col-5" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="1313">노령견케어
							  </label>
							</div>
							<div class="btn-group col-5" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="1358">환자견케어
							  </label>
							</div>
							<div class="btn-group col-5" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="1355,1356">자격증보유
							  </label>
							</div>
							<div class="btn-group col-4" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="1352">실외배변
							  </label>
							</div>
							<div class="btn-group col-4" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="1357">픽업가능
							  </label>
							</div>
							<div class="btn-group col-4" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="1353">수제간식
							  </label>
							</div>
							<div class="btn-group col-7" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="no_dog">반려견 없는 곳
							  </label>
							</div>
							<div class="btn-group col-4" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="1359">응급처치
							  </label>
							</div>
							<div class="btn-group col-4" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="1351">투약가능
							  </label>
							</div>
							<div class="btn-group col-3" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off" value="1323">대형견
							  </label>
							</div>
						</dd>
          </dl>
        </li>
      </ul>
    </form>
    <div class="status inner row hidden-xs">
			<div class="col-sm-6"><strong>227명</strong>의 검증된 펫시터가 검색되었습니다!</div>
			<div class="col-sm-6 text-right">
				<button type="button" class="btn btn-link">검색 설정 초기화 하기</button>
			</div>
    </div>
    <div class="orders inner text-right hidden-xs">
			<img src="/static/img/search/icon-orders.png">
			<div class="btn-group" data-toggle="buttons">
				<label class="btn">
					<input type="checkbox" name="order" autocomplete="off" value="score">· &nbsp;점수
				</label>
				<label class="btn">
					<input type="checkbox" name="order" autocomplete="off" value="review">· &nbsp;리뷰
				</label>
			</div>
    </div>
    
    
    
    
    
    
    

	
</body>
</html>