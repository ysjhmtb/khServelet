<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<style>
.block {
	display: inline-block;
	float: left;
	width: 270px;
	border: 1px solid #f9c0c8;
	padding: 11px 20px 19px;
	border-radius: 8px;
	margin: 0 12px 10px 0;
	height: 320px;
}

.icons {
	display: inline-block;
	float: left;
	padding: 0 0 0 0;
}

.icons li {
	display: inline-block;
	float: left;
	padding: 0 9px 0 0;
	position: relative;
}

.icons li em {
	font-family: 'Noto Sans', sans-serif;
	font-size: 13px;
	line-height: 13px;
	color: #333333;
	padding: 10px 0 0 0;
	display: block;
	font-weight: 700;
}

.stars {
	display: block;
	float: right;
	padding: 9px 0 0 0
}

.stars li {
	display: inline-block;
	float: left;
	padding: 0 0 0 0;
}

.stars li img {
	width: 13px;
	height: 12px;
	display: block;
}



.block small {
	position: absolute;
	top: 0px;
	right: 0px;
	font-family: 'Noto Sans', sans-serif;
	font-size: 12px;
	line-height: 14px;
	color: #222222;
	background: #f9c0c8;
	border-radius: 0 0 0 8px;
	padding: 5px 5px 5px 10px;
}

.isSafeArea {
	display: inline;
}



.clear {
    clear: both;
    font-size: 1px;
    line-height: 1px;
    display: block;
    height: 0;
}

.block span {
    display: block;
    position: relative;
    margin: 8px auto 0;
    width: 100%;
    padding: 0 0 15px 0;
}

.block  small {
    position: absolute;
    top: 0px;
    right: 0px;
    font-family: 'Noto Sans', sans-serif;
    font-size: 12px;
    line-height: 10px;
    color: #222222;
    background: #f9c0c8;
    border-radius: 0 0 0 8px;
     padding: 5px 5px 5px 10px;
}

.img_wrapper {
	
	width: 100%;
	height: 139px;
	overflow: hidden;
	position: relative;
}

img_wrapper img {
	width: 100%;
	min-height: 100%;
	top: -100%;
	bottom: -100%;
	left: -100%;
	right: -100%;
	margin: auto;
	position: absolute;
}

.block p {
    font-family: 'Noto Sans', sans-serif;
    font-size: 14px;
    line-height: 18px;
    color: #444444;
    padding: 0 19px 8px 0;
    margin-bottom:10px;
}
</style>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>

	<div class="block">
		<ul class="icons">
			<li><em>닉네임</em></li>
			<li class="tool_click">
				<div class="isSafeArea">
					<abbr title="신규펫시터 : 본인인증 완료 & 온/오프라인 교육 수료한 펫시터"> <img
						src="../../images/borderIcon/icon5.png" />
					</abbr>
				</div>
			</li>
		</ul>
		<ul class="stars">
			<li><img src="../../images/borderIcon/yellow_star.png" ></li>
			<li><img src="../../images/borderIcon/yellow_star.png" ></li>
			<li><img src="../../images/borderIcon/yellow_star.png" ></li>
			<li><img src="../../images/borderIcon/yellow_star.png" ></li>
			<li><img src="../../images/borderIcon/yellow_star.png" ></li>
		</ul>
		<div class="clear"></div>
    <span>
    	<a href="#">
            <div class="img_wrapper">
                <img src="../../upload/petsitter/201604141730140affddf6059f07df61e6e98b920afaab64575.jpg.thumb" alt="dog" >
            </div>
    	</a>
    	<small>20000원~</small>
    </span>
		 <p style="width:270px;height:44px; word-break: break-all; word-wrap: break-word; overflow: hidden; font-size:12px; line-height: 13px;">어려서부터 지금껏 평생 반려견과 함께 생활해 누구보다 반려인들의 마음을 잘 알기에 내집같이 쾌적하고 편한 환경에서 내아이처럼 정성껏 돌봐드리고자 이 일을 시작하게 되었답니다.
저희집은 아파트이지만 바로옆에 산책하기 좋은 동산들과 서울둘레길, 그리고 한강시민공원이 있어 매일 산책은 기본이구요, 간식도 저희 아이들과 똑같이 수제간식 만들어서 먹인답니다.
4개의 방을 비롯해 각 공간마다 안전문이 설치돼있어, 아이들 컨디션이나 성향에 따라 분리케어를 원하실 경우,보호자님과 상담후 협의하에 분리케어도 가능합니다. 
눈에 넣어도 아프지 않을 우리 아이들 엄마같은 따뜻한 펫시터에게 안심하고 맡겨주세요
※체크인은 오전9시부터 오후10시 이내까지 가능하고, 체크아웃은 오후 10시로 종료되며,초과시 케어시간과 관계없이 1박요금이 추가 청구됩니다
</p>
		 
		 <div style="display: inline-block;margin-top:5px; height:35px;">
        <img src="../images/state1.png" width="82" height="16" alt="icon" onerror="this.style.display='none'" style="margin-left:5px;">
        <img src="../images/{{isExistChild}}" width="82" height="16" alt="icon" onerror="this.style.display='none'" style="margin-left:5px;">
        <img src="../images/{{isExistCam}}" width="82" height="16" alt="icon" onerror="this.style.display='none'" style="margin-left:5px;">
        <img src="../images/state4.png" width="82" height="16" alt="icon" onerror="this.style.display='none'" style="margin-left:5px;">
        <img src="../images/state5.png" width="82" height="16" alt="icon" onerror="this.style.display='none'" style="margin-left:5px;">
    </div>

    <a class="pin" href="#" style="display: block; margin-top:10px;">서울 강동구</a>
    <img src="../images/host_type3.png" width="{{host_type_width}}" height="16" style="float: right;margin-top:-17px;">
		 
		 
	</div>

</body>
</html>