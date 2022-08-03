package com.my.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

public class Memoinsert2 {

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("�ۼ���: ");
		String name=sc.nextLine();
		System.out.println("�޸� ����: ");
		String msg= sc.nextLine();
		System.out.println(name+"/"+msg);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. DB����
		String url="jdbc:mysql://localhost:3306/schooldb?characterEncoding=UTF-8";
		//��������:dbms����://host:port/database
		String user="root",pwd="multi123";
		
		Connection con=DriverManager.getConnection(url,user,pwd);
		
		//PreparedStatement�� �������� �ٲ�� �� �κ��� �� �Ķ����(?)�� ��ġ�ؼ� sql���� �ۼ��Ѵ�.
		//					=>�� �Ķ���͸� ������ sql���� �̸� �������ؼ� �غ���� ���´�.
		
		String sql="inset into memo(name,msg,wdate) values(?,?,now())";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		con.close();
	}

}
