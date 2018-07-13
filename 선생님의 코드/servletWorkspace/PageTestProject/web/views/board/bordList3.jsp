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
		


   </style>

<%@include file="../common/header.jsp" %>


	  <div class="main-wrap no-profile">
    <div class="states-tabs inner">
      <ul class="nav nav-tabs text-center hide" role="tablist"></ul>
			<div class="visible-xs-block text-center">
				<button type="button" class="btn btn-default">검색 필터 설정하기</button>
			</div>
        <!-- 서브 목록 이벤트 바로가기 링크 -->
        <!-- <a href="/event/Model_dog" class="hidden-xs promotion" target="_self">
				<span class="badge">이벤트</span>도그메이트의 모델견이 되어주세요! -->
			</a>
			
    </div>
    <form class="filters inner" style="width:400px; height:400px;">
			<div class="visible-xs-block text-center">
				<h3>검색 필터 설정하기</h3>
				<button type="button" aria-label="Close" class="close">
					<span aria-hidden="true">&times;</span></button>
			</div>
      <ul class="clearfix">
        <li class="col-type">
          <dl>
            <dt>서비스</dt>
            <dd>
              <select class="selectpick hidden-xs" name="service_type"
								data-width="120px">
                <option title="24시간 돌봄" value="1"
									 selected="selected">24시간 돌봄</option>
                <option title="데이케어" value="2"
									>데이케어</option>
              </select>
							<input type="radio" id="service-type-0" class="radiobox"
								name="service_type" value="1"
								 checked="checked"/>
							<label for="service-type-0"
								class="visible-xs-inline-block">24시간 돌봄</label>
							<input type="radio" id="service-type-1" class="radiobox"
								name="service_type" value="2"
								/>
							<label for="service-type-1"
								class="visible-xs-inline-block">Day Care</label>
            </dd>
          </dl>
        </li>
        <li class="col-dates">
          <dl>
            <dt>예약일을 알려주세요!</dt>
            <dd class="clearfix text-center">
              <input type="text" class="pull-left" placeholder="시작 날짜"
							 	readonly="readonly" value="" />
              <span>&gt;</span>
              <input type="text" class="pull-right" placeholder="마침 날짜"
							 	readonly="readonly" value="" />
            </dd>
          </dl>
        </li>
        <li class="col-age">
          <dl>
            <dt>반려견 나이</dt>
            <dd>
              <select class="selectpick hidden-xs" multiple title="모든 연령"
                name="ages" data-width="130px">
                <option title="강아지" value="1311"
									>강아지 (1살 이하)</option>
                <option title="성견" value="1312"
									>성견 (2~6살)</option>
                <option title="노령견" value="1313"
									>노령견 (7살 이상)</option>
              </select>
							<input type="checkbox" id="ages-0" class="checkbox"
								name="ages" value="1311"
								/>
							<label for="ages-0"
								class="visible-xs-block">강아지 (1살 이하)</label>
							<input type="checkbox" id="ages-1" class="checkbox"
								name="ages" value="1312"
								/>
							<label for="ages-1"
								class="visible-xs-block">성견 (2~6살)</label>
							<input type="checkbox" id="ages-2" class="checkbox"
								name="ages" value="1313"
								/>
							<label for="ages-2"
								class="visible-xs-block">노령견 (7살 이상)</label>
            </dd>
          </dl>
        </li>
        <li class="col-size">
          <dl>
            <dt>반려견 크기</dt>
            <dd>
              <select class="selectpick hidden-xs" multiple title="모든 크기"
                name="sizes" data-width="130px">
                <option title="소형견" value="1321"
									>소형견 (0~4.9kg)</option>
                <option title="중형견" value="1322"
									>중형견 (5~14.9kg)</option>
                <option title="대형견" value="1323"
									>대형견 (15kg 이상)</option>
              </select>
							<input type="checkbox" id="sizes-0" class="checkbox"
								name="sizes" value="1321"
								/>
							<label for="sizes-0"
								class="visible-xs-block">소형견 (0~4.9kg)</label>
							<input type="checkbox" id="sizes-1" class="checkbox"
								name="sizes" value="1322"
								/>
							<label for="sizes-1"
								class="visible-xs-block">중형견 (5~14.9kg)</label>
							<input type="checkbox" id="sizes-2" class="checkbox"
								name="sizes" value="1323"
								/>
							<label for="sizes-2"
								class="visible-xs-block">대형견 (15kg 이상)</label>
            </dd>
          </dl>
        </li>
        <li class="col-level pull-left">
          <dl>
            <dt>펫시터 등급</dt>
            <dd>
              <select class="selectpick hidden-xs" multiple title="모든 등급"
                name="levels" data-width="120px">
                <option title="우수"
									value="1"
									>우수									펫시터</option>
                <option title="일반"
									value="2"
									>일반									펫시터</option>
                <option title="신규"
									value="3"
									>신규									펫시터</option>
              </select>
							<input type="checkbox" id="levels-0" class="checkbox"
								name="levels" value="1"
								/>
							<label for="levels-0"
								class="visible-xs-block"><span
								class="circle gold"></span>
								우수 펫시터</label>
							<input type="checkbox" id="levels-1" class="checkbox"
								name="levels" value="2"
								/>
							<label for="levels-1"
								class="visible-xs-block"><span
								class="circle silver"></span>
								일반 펫시터</label>
							<input type="checkbox" id="levels-2" class="checkbox"
								name="levels" value="3"
								/>
							<label for="levels-2"
								class="visible-xs-block"><span
								class="circle bronze"></span>
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
							    <input type="checkbox" name="tag" autocomplete="off"
										value="1201"
										>아파트
							  </label>
							</div>
							<div class="btn-group col-2" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off"
										value="has_house_yard"
										>마당
							  </label>
							</div>
							<div class="btn-group col-5" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off"
										value="1313"
										>노령견케어
							  </label>
							</div>
							<div class="btn-group col-5" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off"
										value="1358"
										>환자견케어
							  </label>
							</div>
							<div class="btn-group col-5" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off"
										value="1355,1356"
										>자격증보유
							  </label>
							</div>
							<div class="btn-group col-4" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off"
										value="1352"
										>실외배변
							  </label>
							</div>
							<div class="btn-group col-4" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off"
										value="1357"
										>픽업가능
							  </label>
							</div>
							<div class="btn-group col-4" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off"
										value="1353"
										>수제간식
							  </label>
							</div>
							<div class="btn-group col-7" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off"
										value="no_dog"
										>반려견 없는 곳
							  </label>
							</div>
							<div class="btn-group col-4" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off"
										value="1359"
										>응급처치
							  </label>
							</div>
							<div class="btn-group col-4" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off"
										value="1351"
										>투약가능
							  </label>
							</div>
							<div class="btn-group col-3" data-toggle="buttons">
								<label class="btn btn-xs btn-block">
							    <input type="checkbox" name="tag" autocomplete="off"
										value="1323"
										>대형견
							  </label>
							</div>
						</dd>
          </dl>
        </li>
      </ul>
    </form>
    <div class="status inner row hidden-xs">
			<div class="col-sm-6"><strong>278명</strong>의 검증된 펫시터가 검색되었습니다!</div>
			<div class="col-sm-6 text-right">
				<button type="button" class="btn btn-link">검색 설정 초기화 하기</button>
			</div>
    </div>
   
	</div>
	<div class="list-box">
    
    </div>
	
</body>
</html>