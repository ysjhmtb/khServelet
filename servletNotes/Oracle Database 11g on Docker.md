

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

처음 사용했던 다커 이미지로는 sqlplus를 사용할 수가 없어서, 다른 이미지로 다시 시작.

<br>

```
docker run --name orcldb -d -p 59160:22 -p 59161:1521 -v ~/my/oracle/data:/u01/app/oracle sath89/oracle-xe-11g
```

<br>

```
sudo docker ps

sudo docker port orcldb

sudo docker images

sudo docker exec -it orcldb bash

sqlplus
```

<br>

```sql
수업에서 사용한 SQL :




 -- 관리자 계정 --

CREATE USER jsp IDENTIFIED BY jsp;

GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE SEQUENCE TO jsp;

 -- jsp 계정 --
drop table ATTACHMENT;
drop table BOARD_COMMENT;
drop table BOARD;
drop table notice;
drop table member;

drop SEQUENCE SEQ_NNO;
drop SEQUENCE SEQ_BOARD;
drop SEQUENCE SEQ_COMMENT;
drop SEQUENCE SEQ_FNO;


CREATE TABLE MEMBER(
  USERID VARCHAR2(30) PRIMARY KEY
 ,PASSWORD VARCHAR2(100) NOT NULL
 ,USERNAME  VARCHAR2(30) NOT NULL
 ,GENDER CHAR(1) CHECK (GENDER IN ('M','F'))
 ,AGE NUMBER
 ,EMAIL VARCHAR2(30)
 ,PHONE CHAR(13)  NOT NULL
 ,ADDRESS VARCHAR2(500)
 ,HOBBY VARCHAR2(100)
 ,ENROLLDATE DATE DEFAULT SYSDATE
);


INSERT INTO MEMBER VALUES
('admin', 'admin', '홍길동', 'M', 10, 'test@test.com', '01011112222', '서울시 강남구', '게임, 음악, 영화감상', DEFAULT);

COMMIT;

CREATE TABLE NOTICE (
    NNO NUMBER PRIMARY KEY,
    NTITLE VARCHAR2(100) NOT NULL,
    NCONTENT VARCHAR2(4000) NOT NULL,
    NWRITER VARCHAR2(30) NOT NULL,
    NCOUNT NUMBER DEFAULT 0,
    NDATE DATE DEFAULT SYSDATE,
    FOREIGN KEY (NWRITER) REFERENCES MEMBER(USERID)
);

CREATE SEQUENCE SEQ_NNO;

--COMMIT;

INSERT INTO NOTICE VALUES(
SEQ_NNO.NEXTVAL, '[공지]서버 오픈', '서버가 오픈하였습니다. 많은 이용 바랍니다.', 'admin', DEFAULT, DEFAULT
);

INSERT INTO NOTICE VALUES(
SEQ_NNO.NEXTVAL, '[공지]서버 정기 점검', '서버 정기 점검입니다. 이용에 불편을 드려 대단히 죄송합니다.', 'admin', DEFAULT, DEFAULT
);

INSERT INTO NOTICE VALUES(
SEQ_NNO.NEXTVAL, '[공지]서버 임시 점검', '서버가 더 나은 기능을 제공하기 위하여 지금부터 임시 점검에 들어갑니다. 불편하시더라도 많은 양해 부탁드립니다.', 'admin', DEFAULT, DEFAULT
);

INSERT INTO NOTICE VALUES(
SEQ_NNO.NEXTVAL, '[공지]서버 긴급 점검', '서버에 문제가 발생하여 긴급 점검을 실시합니다. 이용하시는 고객님들은 즉시 로그아웃 해주시기 바랍니다.', 'admin', DEFAULT, DEFAULT
);

INSERT INTO NOTICE VALUES(
SEQ_NNO.NEXTVAL, '[공지]서버 연장 점검', '서버 문제를 해결하던 중 노루가 전봇대를 들이받아 사용자 접속 기능에 오류가 발생하게 되어 서버 오픈을 30분 연장하게 되었습니다. 대단히 죄송합니다.', 'admin', DEFAULT, DEFAULT
);

COMMIT;

-- 공지사항 전체 조회
SELECT * FROM NOTICE
ORDER BY NDATE;

-- 공지사항 한개 조회
SELECT * FROM NOTICE
WHERE NNO = '1';

CREATE TABLE BOARD(
        BNO NUMBER PRIMARY KEY,
        BTITLE VARCHAR2(100) NOT NULL,
        BCONTENT VARCHAR2(4000) NOT NULL,
        BWRITER VARCHAR2(30),
        BCOUNT NUMBER DEFAULT 0,
        BOARDFILE VARCHAR2(2000),
        BDATE DATE DEFAULT SYSDATE,
        DELFLAG CHAR(1) DEFAULT 'N' CHECK( DELFLAG IN ('Y', 'N')),
        CONSTRAINT FK_WRITER FOREIGN KEY (BWRITER)
        REFERENCES MEMBER(USERID) ON DELETE SET NULL
);

CREATE SEQUENCE SEQ_BOARD;

CREATE TABLE BOARD_COMMENT(
        CNO NUMBER PRIMARY KEY,
        BNO NUMBER NOT NULL,
        CCONTENT VARCHAR2(4000) NOT NULL,
        CWRITER VARCHAR2(30),
        CDATE DATE DEFAULT SYSDATE,
        DELFLAG CHAR(1) DEFAULT 'N' CHECK( DELFLAG IN ('Y', 'N')),
        CONSTRAINT FK_BNO FOREIGN KEY (BNO)
        REFERENCES BOARD (BNO) ON DELETE CASCADE,
        CONSTRAINT FK_C_WRITER FOREIGN KEY (CWRITER)
        REFERENCES MEMBER (USERID) ON DELETE SET NULL
);

CREATE SEQUENCE SEQ_COMMENT;

CREATE TABLE ATTACHMENT (
  FNO NUMBER PRIMARY KEY,
  BNO NUMBER NOT NULL,
  BTYPE NUMBER,
  ORIGIN_NAME VARCHAR2(255) NOT NULL,
  CHANGE_NAME VARCHAR2(255) NOT NULL,
  FILE_PATH VARCHAR2(1000) NOT NULL,
  UPLOAD_DATE DATE DEFAULT SYSDATE,
  FILE_LEVEL NUMBER,
  DOWNLOAD_COUNT NUMBER DEFAULT 0,
  DELFLAG VARCHAR2(1) DEFAULT 'N',
  FOREIGN KEY (BNO) REFERENCES BOARD(BNO)  
);

CREATE SEQUENCE SEQ_FNO;


```

<br>

아래와 같이 JDBC 연결을 확인할 수 있다. (한글이 제대로 출력되지는 않는다.)

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
			
		    stmt = con.createStatement();
		    rset = stmt.executeQuery("select * from member where userid = 'admin'");
		    
		    while(rset.next()) {
		    	System.out.println(rset.getString("username"));
		    }
		    
			System.out.println("Connection Success :)");
		}	catch ( SQLException e ) {
			System.out.println(e.getMessage());
			System.out.println("Connection Failed :(");
		}
	}
}
 ```

<br>

Sequel Pro를 연결하려고 했으나 실패.

<br>

<hr>

[가장 빨리 만나는 Docker](http://pyrasis.com/docker.html)

<br>

<hr>

한글 입력이 제대로 되지 않아서, 우선 system / oracle 계정에서 

```sql
SELECT value$ FROM sys.props$ WHERE name = 'NLS_CHARACTERSET';
```

입력하고,  **AL32UTF8** 를 확인하였다.

<br>

jsp / jsp 계정에서 

```sql
SELECT * FROM NLS_DATABASE_PARAMETERS;
```

를 입력하고, 

<br>

```
PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_LANGUAGE
AMERICAN

NLS_TERRITORY
AMERICA

NLS_CURRENCY
$


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_ISO_CURRENCY
AMERICA

NLS_NUMERIC_CHARACTERS
.,

NLS_CHARACTERSET
AL32UTF8


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_CALENDAR
GREGORIAN

NLS_DATE_FORMAT
DD-MON-RR

NLS_DATE_LANGUAGE
AMERICAN


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_SORT
BINARY

NLS_TIME_FORMAT
HH.MI.SSXFF AM

NLS_TIMESTAMP_FORMAT
DD-MON-RR HH.MI.SSXFF AM


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_TIME_TZ_FORMAT
HH.MI.SSXFF AM TZR

NLS_TIMESTAMP_TZ_FORMAT
DD-MON-RR HH.MI.SSXFF AM TZR

NLS_DUAL_CURRENCY
$


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_COMP
BINARY

NLS_LENGTH_SEMANTICS
BYTE

NLS_NCHAR_CONV_EXCP
FALSE


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_NCHAR_CHARACTERSET
AL16UTF16

NLS_RDBMS_VERSION
11.2.0.2.0


20 rows selected.

```

를 확인하였다. 다행히 **NLS_CHARACTERSET** 은 **AL32UTF8** 임을 확인하였는데, 아무래도 **NLS_LANGUAGE** 를 변경해야 할 것 같다.

<br>

<hr>

<br>

```sql
SELECT * FROM NLS_DATABASE_PARAMETERS;
```

<br>

```
PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_LANGUAGE
AMERICAN

NLS_TERRITORY
AMERICA

NLS_CURRENCY
$


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_ISO_CURRENCY
AMERICA

NLS_NUMERIC_CHARACTERS
.,

NLS_CHARACTERSET
AL32UTF8


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_CALENDAR
GREGORIAN

NLS_DATE_FORMAT
DD-MON-RR

NLS_DATE_LANGUAGE
AMERICAN


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_SORT
BINARY

NLS_TIME_FORMAT
HH.MI.SSXFF AM

NLS_TIMESTAMP_FORMAT
DD-MON-RR HH.MI.SSXFF AM


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_TIME_TZ_FORMAT
HH.MI.SSXFF AM TZR

NLS_TIMESTAMP_TZ_FORMAT
DD-MON-RR HH.MI.SSXFF AM TZR

NLS_DUAL_CURRENCY
$


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_COMP
BINARY

NLS_LENGTH_SEMANTICS
BYTE

NLS_NCHAR_CONV_EXCP
FALSE


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_NCHAR_CHARACTERSET
AL16UTF16

NLS_RDBMS_VERSION
11.2.0.2.0


20 rows selected.

SQL> SQL> SELECT * FROM NLS_DATABASE_PARAMETERS;

출처: http://kittyphunk.tistory.com/5 [forever in the rain]SP2-0734: unknown command beginning "출처: ht..." - rest of line ignored.
SQL>SELECT * FROM NLS_DATABASE_PARAMETERS;
SP2-0734: unknown command beginning "출처: ht..." - rest of line ignored.
SQL>         
SQL> SELECT * FROM NLS_DATABASE_PARAMETERS;

PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_LANGUAGE
AMERICAN

NLS_TERRITORY
AMERICA

NLS_CURRENCY
$


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_ISO_CURRENCY
AMERICA

NLS_NUMERIC_CHARACTERS
.,

NLS_CHARACTERSET
AL32UTF8


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_CALENDAR
GREGORIAN

NLS_DATE_FORMAT
DD-MON-RR

NLS_DATE_LANGUAGE
AMERICAN


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_SORT
BINARY

NLS_TIME_FORMAT
HH.MI.SSXFF AM

NLS_TIMESTAMP_FORMAT
DD-MON-RR HH.MI.SSXFF AM


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_TIME_TZ_FORMAT
HH.MI.SSXFF AM TZR

NLS_TIMESTAMP_TZ_FORMAT
DD-MON-RR HH.MI.SSXFF AM TZR

NLS_DUAL_CURRENCY
$


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_COMP
BINARY

NLS_LENGTH_SEMANTICS
BYTE

NLS_NCHAR_CONV_EXCP
FALSE


PARAMETER
------------------------------
VALUE
--------------------------------------------------------------------------------
NLS_NCHAR_CHARACTERSET
AL16UTF16

NLS_RDBMS_VERSION
11.2.0.2.0


20 rows selected.

```

<br>

sqlplus에서 나와서 다커 터미널에서

```bash
root@1f54f877de4b:/# export NLS_LANG=KOREAN_KOREA.AL32UTF8
```

<br>

```Sql
SQL> SELECT '한글' FROM DUAL;
```

<br>

한글 입력 테스트를 시도했을 때 바로 되지는 않고, 재시도했을 때 성공했다.

<br>

<hr>













