```
ajax 파라미터 간략 요약

url - 호출 할 servlet의 url 
	ex)index.do

settings
	accept	- 파라미터의 타입을 설정(사용자 특화 된 파라미터 타입 설정 가능)
	async	- 서버와의 비동기 처리 방식 설정 여부(기본값 true)
	beforeSend - ajax 요청을 하기 전 실행 되는 이벤트 callback 함수(데이터 가공 및 header 관련 설정)
	cache	- 요청 및 결과값을 scope에서 갖고 있지 않도록 하는것(기본값 true)
	complete - 요청 완료 후 실행되는 메소드(성공, 에러 이 후에 무조건 실행)
	contents - jquery 에서 response의 데이터를 파싱하는 방식 정의
	contentType - request의 데이터 인코딩 방식 정의,(보내는 측의 데이터 인코딩)
	context	- ajax 메소드 내 모든 영역에서 사용 가능한 값
	converters - object가 포함되었을때 파싱 방식 정의
	crossDomain - 타 도메인 호출 가능 여부 설정 (기본값 false)
	data	- 요청 parameter 설정
	dataFilter - response를 받았을때 정상적인 값을 return 할수 있도록 데이터와 데이터 타입 설정
	dataType - 서버에서 response 오는 데이터의 데이터 형 설정
		xml - 트리 형태의 데이터 구조
		json - 맵 형식의 데이터 구조(일반적인 데이터 구조)
		script - javascript 및 일반 string 형태 데이터 
		html - html태그 자체를 return 하는 방식
		text - string 데이터
	error	- request 처리 중 오류가 발생 한 경우
	global	- 기본 이벤트 사용 여부(ajaxStart, ajaxStop)(버퍼링 같이 시작과 끝을 나타낼때, 선처리 작업)
	method	- 서버 요청 방식(GET, POST, PUT)
	password - 서버에 접속 권한(비밀번호)가 필요한 경우
	processData - 서버로 보내는 값에 대한 형태 설정 여부(기본데이터를 원하는 경우 false 설정)
	success - 서버에서의 return 이 정상적으로 온 경우
	timeout - 서버 요청 시 응답 대기 시간(milisecond)
	url	- 요청 할 server의 url
```

 