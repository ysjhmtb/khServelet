<h1>MVC(model 2)</h1>

<br>

model : service, value object, database access object 

<br>

view : 화면 

<br>

controller : view와 model 사이에서 연결해주는 역할. servlet.

 <br>

<hr>

<br>

login.do 즉, LoginServlet.java가 servlet.

<br>

LoginServlet.java => service / MemberService.java => dao / MemberDao.java => vo / MemberVo.java

<br>

<hr>

dao에 포함되어 있는 JDBC.

<br>

```java
public MemberVo login(String id, String pwd) {
		MemberVo result = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1.커넥션 생성.
			//실행 할 jdbc 라이브러리 등록.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속 정보 설정.
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:59161:XE", "jsp", "jsp");
			
			//2.쿼리 실행 객체 생성.
			stmt = con.createStatement();
			
			//쿼리 작성 시 주의사항. 변수의 앞 뒤로 ' 필요.
			String query = "SELECT * FROM MEMBER "
					+ "WHERE USERID = '" + id + "' AND PASSWORD = '" 
					+ pwd + "'";
			
			//3.쿼리 실행.
			rs = stmt.executeQuery(query);
			
			//4.실행결과를 객체로 변환.
			while(rs.next()) {
				result = new MemberVo();
				result.setUserId(id);
				result.setPassword(pwd);
				result.setUserName(rs.getString("username"));
				result.setAddress(rs.getString("address"));
				result.setAge(rs.getInt("age"));
				result.setEnrolldate(rs.getDate("enrolldate"));
				
			}
			
		
				
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//역순으로 닫기.
			
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
```



<br>

<hr>

