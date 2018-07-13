<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="canonical" href="https://www.dogmate.co.kr/reserve/search" />
<link rel="shortcut icon" href="/static/img/common/favicon.ico" />
<link href="<%=request.getContextPath()%>/static/js/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/static/js/bower_components/select2/dist/css/select2.min.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/static/js/bower_components/bootstrap-fileinput/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/common/reset.css" />
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/static/css/common/datepicker.css' />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/common/popup-bnr.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/common/common.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/common/common_sp.css" />
<!-- <link rel="stylesheet" type="text/css" href="/static/css/slide/jquery.fancybox-1.3.4.css"/> -->
<!-- 2016.02.17 ara start -->
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/static/js/bower_components/slick-carousel/slick/slick.css'>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/static/js/bower_components/slick-carousel/slick/slick-theme.css'>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/static/js/bower_components/bootstrap-select/dist/css/bootstrap-select.min.css'>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/static/css/search.css'>


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
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/headroom.js/dist/headroom.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/headroom.js/dist/jQuery.headroom.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/bootstrap-fileinput/js/fileinput.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/jquery.cookie/jquery.cookie.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/common/simpler-sidebar.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/common/jquery.rwdImageMaps.js"></script><!-- 2015.12.15 ara 추가 -->

	<script src="<%=request.getContextPath()%>/static/js/jquery.ui.widget.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/jquery.easing.1.3.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/bower_components/blueimp-file-upload/js/jquery.iframe-transport.js"></script>
	<script type='text/javascript'
			src="<%=request.getContextPath()%>/static/js/bower_components/blueimp-file-upload/js/jquery.fileupload.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/imgLiquid-min.js"></script>



<title>예약하기</title>

</head>
<body>
<!-- %@include file="../common/header.jsp" %-->


 <div class="main-wrap no-profile">
    <div class="states-tabs inner">
      <ul class="nav nav-tabs text-center headroom headroom--top headroom--not-bottom" role="tablist">
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
      <button type="button" aria-label="Close" class="close visible-xs-block"><span aria-hidden="true">×</span></button></div></li></ul>
      
    
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
    </div>
	
</body>
</html>