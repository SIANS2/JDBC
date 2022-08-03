package com.my.jdbc;
import java.sql.*;
//JDBC : java Database Connectivity
//java 언어 <==== Driver[통역사] =====> DB sql 언어
//JDBC DRIVER를 다운로드 받아야한다. => DBMS마다 제공되는
public class MemoCreate {

	public static void main(String[] args) {
		// 1. 드라이버 로딩
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success...");
		// 2. DB연결
		String url="jdbc:mysql://localhost:3306/schooldb?characterEncoding=UTF-8";
					//프로토콜:dbms유형://host:port/database
		String user="root",pwd="multi123";
		
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("DB연결 성공!");
		//3, query 문 작성하기
		String sql="create table if not exists memo("
				+ "idx int auto_increment primary key,"
				+ "name varchar(20) not null,"
				+"msg varchar(100),"
				+"wdate datetime default now() )";
		//4. Statement 객체 얻어오기==> sql문을 실행시킬 수 있는 객체
		//	PreparedStatement
		Statement stmt=con.createStatement();
		//5. sql문 실행시키기
		stmt.execute(sql);
		System.out.println("Memo테이블 생성 성공(테이블은 딱 한번만 생성 가능해요!)");
		//6. db 연결지원 해제
		stmt.close();
		con.close();
		
	}catch(ClassNotFoundException e) {
		System.out.println("드라이버 로딩 실패:"+e);
		
	}catch(SQLException e) {
		e.printStackTrace();
	}

}
}
