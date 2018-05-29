<br>

Log4j2.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration status="WARN">
 <appenders>
  <Console name="console" target="SYSTEM_OUT">
   <!-- <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" /> -->
   <PatternLayout pattern="%style{%d [%t]}{Magenta} %highlight{%-5level: %msg%n%throwable}" />
   
  </Console>
<!--
참조 사이트 : https://logging.apache.org/log4j/2.x/
API : https://logging.apache.org/log4j/2.0/log4j-api/apidocs/index.html?overview-summary.html
패턴 예시 : https://logging.apache.org/log4j/2.x/manual/layouts.html
log4j 3대 요소
 (1) Logger : logging 메시지를 Appender에 전달.
 (2) Appender : 전달된 로깅 메시지를 파일, 콘솔, DB에 저장 할 지 지정하는 역할을 한다.
 (3) Layout : Appender가 어디에 출력 할 것인지 결정했다면 어떠한 형식으로 출력을 할 지 출력 layout을 결정
 
log4j level
      logging 레벨은 TRACE < DEBUG < INFO < WARN < ERROR and FATAL 이며,
      1) FATAL : 가장 크리티컬한 에러가 났을 때 사용.
      2) ERROR : 일반 에러가 났을 경우 사용.
      3) WARN : 에러는 아니지만 주의할 필요있을 때 사용.
      4) INFO : 일반 정보를 나타날 때 사용.
      5) DEBUG : 일반 정보를 상세히 나타낼 때 사용.
      6) TRACE : 가장 레벨이 낮은 단계, 보통 DEBUG로 많이 하며 TRACE는 본적이...;
      debug 레벨로 했다면 INFO~FATAL까지 모두 logging이 되어집니다.
      운영모드라면 INFO레벨로 하면 됩니다.  
 -->
  <RollingFile name="file" fileName="/Users/yunseokjeon/git/khServlet/khWorkspace/thirdWebProject/logs/all.log" filePattern="logs/all.%i.%d{yyyy-MM-dd}.log">
   <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" />
   <Policies>
    <SizeBasedTriggeringPolicy size="10MB" /> <!-- 이 용량이 초과되면 아래 DefaultRolloverStrategy 정책만큼 넘버링 할거다. -->
   </Policies>
   <DefaultRolloverStrategy max="1000" fileIndex="min" /><!-- 0부터 1000개 까지만 만들거다 1000개 초과되면 파일이 더생성안된다. -->
  </RollingFile>
 </appenders>

 <loggers>
 
  <!-- 모든 로그는 dubug레벨 이상일때만 찍고 -->
  <root level="debug" additivity="false" >
   <appender-ref ref="console" />
   <appender-ref ref="file" />
  </root>

  <!-- 로그많이 찍어대는 요놈들은 warn수준이상만 찍겠다. -->
  <!-- 내패키지는 무조건 찍자 -->
  <logger name="com.kh.java.research.controller" level="trace" additivity="false" >
   <appender-ref ref="console" />
	  <appender-ref ref="file" />
  </logger>

 </loggers>
</configuration>
```



<br>

<hr>

[Log4j 2 XML Configuration Example](https://howtodoinjava.com/log4j2/log4j-2-xml-configuration-example/)

<br>

To include **Log4j2** in your project, include below dependency in your project. <br>

```xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.6.1</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.6.1</version>
</dependency>
```



<br>

콘솔에 로그 남기기. 

아래의 xml 파일이 없다면 DefaultConfiguration 이 사용된다.



[Layouts](https://logging.apache.org/log4j/2.x/manual/layouts.html) 을 참조.





<br>





















