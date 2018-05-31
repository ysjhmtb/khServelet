<h1>Redirect and Forward</h1>

<br>

<hr>

<h3>Redirect</h3>

<br>

브라우저가 응답을 받은 후 다시 보낼 새로운 URL 포함. <br>

Forward 보다 속도가 느리며, URL에 패러미터가 보인다. <br>

웹브라우저에게 재접속 명령을 내리고, 새로운 페이지로 재접속하게 된다. <br>

기존의 request 정보를 잃게 되며, 사용자 주소 창에 새로운 주소로 표시된다. <br>

<br>

<hr>

<br>

<h3>Forward</h3>

<br>

Forward 되는 요청이 다른 서블릿으로 전달되며, 클라이언와 별개로 서버 내에서만 처리되기 때문에 속도가 빠르다. <br>

Forward 한 후에도 객체가 가지고 있던 request attribute을 사용할 수 있다. <br>

URL의 변화는 없다. <br>

<br>

