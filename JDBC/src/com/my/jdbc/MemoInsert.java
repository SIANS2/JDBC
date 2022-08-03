package com.my.jdbc;

import java.sql.DriverManager;
import java.sql.*;
public class MemoInsert {

	public static void main(String[] args) 
	throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. DB����
		String url="jdbc:mysql://localhost:3306/schooldb?characterEncoding=UTF-8";
		//��������:dbms����://host:port/database
		String user="root",pwd="multi123";
		
		Connection con=DriverManager.getConnection(url,user,pwd);
		//db����
		String sql="insert into memo(name,msg,wdate) values('�̻���','�����Ϸ絵 ������...',now())";
		Statement stmt=con.createStatement();
		// stmt.execute(sql); ==> ��� sql���� �����Ű�� �޼���
		//DML ����(insert/update/delete)==> int executeupdate(String sql)
		int n=stmt.executeUpdate(sql);
		//n: sql���� ���Ͽ� ������� ���ڵ� ���� ��ȯ�Ѵ�.
		
		System.out.println(n+"���� �޸���� ����߽��ϴ�!");
		stmt.close();
		con.close();
	}

}
