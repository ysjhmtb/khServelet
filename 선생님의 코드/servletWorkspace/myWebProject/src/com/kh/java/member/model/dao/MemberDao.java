package com.kh.java.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.java.common.JDBCTemplate;
import com.kh.java.member.model.vo.MemberVo;

public class MemberDao {
	
	public MemberVo login(String id, String pwd){
		MemberVo result = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1. 커넥션 생성
			//실행 할 jdbc 라이브러리 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속 정보 설정
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
														"jsp",
														"jsp");
			//2. 쿼리 실행 객체 생성
			stmt = con.createStatement();
			
			//쿼리 작성시 주의 사항 
			//- 스트링 값 비교 시 따옴표를 추가하는 경우 주의
			String query = "SELECT * FROM MEMBER "
					+ " WHERE USERID = '" + id + "' "   // where userid = 'admin' 
					+ " AND PASSWORD = '" + pwd + "'";
			System.out.println(query);
			//3. 쿼리 실행
			rs = stmt.executeQuery(query);
			
			//4. 실행 결과를 객체로 변환
			while(rs.next()){
				result = new MemberVo();
				result.setUserId(id);
				result.setPassword(pwd);
				result.setUserName(rs.getString("username"));
				result.setAddress(rs.getString("address"));
				result.setAge(rs.getInt("age"));
				result.setEnrolldate(rs.getDate("enrolldate"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//자원 반납
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public MemberVo selectMemberId(String id){
		MemberVo result = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//1. 커넥션을 맺는다.
		con = JDBCTemplate.getConnection();
		//2. 쿼리 객체를 생성
		try {
			stmt = con.createStatement();
			//3. 실행 할 쿼리 작성
			String query = "SELECT * FROM MEMBER WHERE USERID = '" + id + "'";
			rs = stmt.executeQuery(query);
			
			//4. 쿼리 실행 결과 처리(resultSet)
			if(rs.next()){
				result = new MemberVo();
				result.setUserId(id);
				result.setPassword(rs.getString("password"));
				result.setUserName(rs.getString("username"));
				result.setGender(rs.getString("gender").charAt(0));
				result.setAge(rs.getInt("age"));
				result.setEmail(rs.getString("email"));
				result.setPhone(rs.getString("phone"));
				result.setAddress(rs.getString("address"));
				result.setHobbyStr(rs.getString("hobby"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. close 처리
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int insertMember(MemberVo m){
		int result = 0;
		//1. 커넥션을 맺는다
		Connection con = JDBCTemplate.getConnection();
		Statement stmt = null;
		try {
			//2. 쿼리 객체를 생성한다.
			stmt = con.createStatement();
			//실행할 쿼리 작성
			String query = "INSERT INTO MEMBER VALUES('"
					+ m.getUserId() + "', '"  // '값', '값'
					+ m.getPassword() + "', '"
					+ m.getUserName() + "', '"
					+ m.getGender() + "', "
					+ m.getAge() + ", '"
					+ m.getEmail() + "', '"
					+ m.getPhone() + "', '"
					+ m.getAddress() + "', '"
					+ m.getHobbyStr() + "', sysdate)";
			System.out.println("insert query : " + query);
			//3. 쿼리 실행 결과를 가져온다.
			//executeQuery -> resultSet(표 형식의 데이터)
			//							-> select 문 호출시 사용
			//executeUpdate -> int(수정/추가/삭제 된 행의 수)
			//							-> 추가/수정/삭제 시 사용
			result = stmt.executeUpdate(query);
			
			//dml의 경우 트랜잭션 처리 필요
			//result - 0이 아닐때 commit
			//result - 0일때 rollback
			if(0 < result){
				con.commit();
			}else{
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMember(MemberVo m){
		int result = -1;
		Connection con = null;
		Statement stmt = null;
		String query = null;
		//1. 데이터베이스 커넥션 생성
		con = JDBCTemplate.getConnection();
		//2. 쿼리 전송 객체 생성
		try {
			stmt = con.createStatement();
			//3. 쿼리 작성
			query = "UPDATE MEMBER "
					+ "SET PASSWORD = '" + m.getPassword() + "',"
						+ "USERNAME = '" + m.getUserName() + "', "
						+ "GENDER = '" + m.getGender() + "', "
						+ "AGE = '" + m.getAge() + "', "
						+ "EMAIL = '" + m.getEmail() + "', "
						+ "PHONE = '" + m.getPhone() + "', "
						+ "ADDRESS = '" + m.getAddress() + "', "
						+ "HOBBY = '" + m.getHobbyStr() + "' "
					+ "WHERE USERID = '" + m.getUserId() + "'";
			System.out.println("query : " + query);
			//4. 실행 결과 처리(int)
			result = stmt.executeUpdate(query);
			
			if(0 < result){
				con.commit();
			}else{
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close처리)
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteMember(String id) {
		int result = 0;
		//1. 커넥션을 맺는다
		Connection con = JDBCTemplate.getConnection();
		Statement stmt = null;
		try {
			//2. 쿼리 객체를 생성한다.
 			stmt = con.createStatement();
			//실행할 쿼리 작성
			String query = "DELETE FROM MEMBER WHERE USERID='"+ id + "'";
			System.out.println("delete query : " + query);
			//3. 쿼리 실행 결과를 가져온다.
			result = stmt.executeUpdate(query);
			//dml의 경우 트랜잭션 처리 필요
			if(0 < result){
				con.commit();
			}else{
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}





















