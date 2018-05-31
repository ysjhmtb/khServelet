

<h1> Oracle Database 11g on Docker </h1>

<br>

<hr>

[맥북에서 오라클 사용하기 (docker + intelliJ)](http://jojoldu.tistory.com/169) 와 [맥(osx)에서 oracle DB 사용하기](https://banbanmumani.github.io/2018/01/05/osx%EC%97%90%EC%84%9CoracleDB%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0/) 참조.

 <br>

다커 컨테이너 생성.

 <br>

```
docker pull wnameless/oracle-xe-11g
```

<br>

컨테이너 실행.

<br>

```
docker run -d -p 59160:22 -p 59161:1521 wnameless/oracle-xe-11g
```

<br>

**-p 59161:1521** 의미 : 오라클 다커 컨테이너의 1521 포트가 로컬호스트(localhost, 127.0.0.1)의 59161포트로 연결되었다.

즉, 로컬호스트의 59161 포트로 접근하면 오라클 데이터베이스에 접근할 수 있다.

<br>

그런데 다커는 무상태를 지향한다. 따라서 컨테이너 실행 중에 생성된 데이터는 컨테이너를 종료하면 데이터는 저장되지 않고 사라진다. 따라서 데이터를 컨테이너 외부에 저장해야 한다. 

<br>

```
docker run --name oracle12c -d -p 8080:8080 -p 1521:1521 -v ~/my/oracle/data:/u01/app/oracle sath89/oracle-12
```

<br>

-v 옵션을 사용하여, **~/my/oracle/data** 경로에 데이터에 저장. 위의 명령어는 12c 에 사용되는 것이므로, 11g에서는 다음과 같다.

<br>

```
docker run --name oracle11g -d -p 59160:22 -p 59161:1521 -v ~/my/oracle/data:/u01/app/oracle wnameless/oracle-xe-11g
```

<br>

<hr>

[Using Oracle Database with Docker Engine](https://community.toadworld.com/platforms/oracle/w/wiki/11638.using-oracle-database-with-docker-engine) 를 참조. 실제 데이터베이스에 데이터를 입력하는 과정을 안내. 여기서는 wnameless/oracle-xe-11g가 아닌 sath89/oracle-xe-11g 를 사용.

<br>

설치.

```
sudo docker pull sath89/oracle-xe-11g
```

<br>

orcldb 라는 이름으로 시작.

```
sudo docker run --name orcldb -d -p 8080:8080 -p 1521:1521 sath89/oracle-xe-11g
```

<br>

현재 동작하고 있는 컨테이너 확인. 

```
sudo docker ps
```

<br>

컨테이너 포트 정보.

```
sudo docker port orcldb
```

<br>

다커 이미지 확인.

```
sudo docker images
```

<br>

다커 터미널 시작.

```
sudo docker exec -it orcldb bash
```

<br>

SQL*Plus 시작.

```
sqlplus
```

<br>

user-name은 **system** , password는 **oracle** 입력. 

<br>

계정 생성 및 권한 부여.

```
DROP USER OE;

CREATE USER OE QUOTA UNLIMITED ON SYSTEM IDENTIFIED BY OE;

Grant CONNECT and RESOURCE roles to the OE user.

GRANT CONNECT, RESOURCE TO OE;
```

<br>

테이블 생성.

<br>

```
CREATE TABLE OE.WLSLOG(time_stamp VARCHAR2(45) PRIMARY KEY,category VARCHAR2(25),type VARCHAR2(25),servername VARCHAR2(25),code VARCHAR2(25),msg VARCHAR2(45));

```

<br>

생성된 테이블에 데이터 입력하기.

<br>

```
INSERT INTO OE.WLSLOG VALUES('Apr-8-2014-7:06:16-PM-PDT','Notice','WebLogicServer','AdminServer','BEA-000365','Server state changed to STANDBY');

INSERT INTO OE.WLSLOG VALUES('Apr-8-2014-7:06:17-PM-PDT','Notice','WebLogicServer','AdminServer','BEA-000365','Server state changed to STARTING');

INSERT INTO OE.WLSLOG VALUES('Apr-8-2014-7:06:18-PM-PDT','Notice','WebLogicServer','AdminServer','BEA-000365','Server state changed to ADMIN');

INSERT INTO OE.WLSLOG VALUES('Apr-8-2014-7:06:19-PM-PDT','Notice','WebLogicServer','AdminServer','BEA-000365','Server state changed to RESUMING');

INSERT INTO OE.WLSLOG VALUES('Apr-8-2014-7:06:20-PM-PDT','Notice','WebLogicServer','AdminServer','BEA-000331','Started WebLogic AdminServer');

INSERT INTO OE.WLSLOG VALUES('Apr-8-2014-7:06:21-PM-PDT','Notice','WebLogicServer','AdminServer','BEA-000365','Server state changed to RUNNING');

INSERT INTO OE.WLSLOG VALUES('Apr-8-2014-7:06:22-PM-PDT','Notice','WebLogicServer','AdminServer','BEA-000360','Server started in RUNNING mode');
```

<br>

데이터 조회하기.

<br>

```
SELECT * FROM OE.WLSLOG;
```

<br>

SQL*Plus 종료.

```
exit
```

<br>

다커 컨테이너 종료.

```
sudo docker stop orcldb
sudo docker ps
```

<br>

다커 컨테이너와 이미지 삭제.

```
sudo docker rm orcldb
sudo docker rmi sath89/oracle-xe-11g
```

<br>

<hr>

[[Database] JDBC 를 이용하여 Oracle DB연동](http://shark.ze.am/database-jdbc-%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%98%EC%97%AC-oracle-db%EC%97%B0%EB%8F%99/) 를 참조하여 컨테이너에서 동작하는 오라클 데이테베이스에 접속.

<br>

```java

import java.sql.*;


public class TestDBAccess {
	public static void main ( String [] args ) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Loading Driver Success :)");
		}	catch ( ClassNotFoundException e ) {
			System.out.print(e.getMessage()+" Not Founded :(");
		}
		
		try {
			String URL = "jdbc:oracle:thin:@localhost:59161:XE";
			con = DriverManager.getConnection(URL, "system", "oracle");
			System.out.println("Connection Success :)");
		}	catch ( SQLException e ) {
			System.out.println(e.getMessage());
			System.out.println("Connection Failed :(");
		}
	}
}

```

<br>

<hr>





 































