package com.my.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

public class Memoinsert2 {

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("작성자: ");
		String name=sc.nextLine();
		System.out.println("메모 내용: ");
		String msg= sc.nextLine();
		System.out.println(name+"/"+msg);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. DB연결
		String url="jdbc:mysql://localhost:3306/schooldb?characterEncoding=UTF-8";
		//프로토콜:dbms유형://host:port/database
		String user="root",pwd="multi123";
		
		Connection con=DriverManager.getConnection(url,user,pwd);
		
		//PreparedStatement는 동적으로 바뀌는 값 부분을 인 파라미터(?)로 대치해서 sql문을 작성한다.
		//					=>인 파라미터를 제외한 sql문을 미리 컴파일해서 준비시켜 놓는다.
		
		String sql="inset into memo(name,msg,wdate) values(?,?,now())";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		con.close();
	}

}
