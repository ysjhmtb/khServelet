# java.sql.Date vs java.util.Date 

 VO 객체인 Notice 클래스에서 import java.sql.Date; 가 아닌 import java.util.Date;  사용하는 경우 **400 에러** 발생.  

 이런 경우를 피하고자 한다면 뷰의 form 태그에서 date 타입이 아닌 text 타입을 전송하는 것이 권장된다.   







