package com.my.jdbc;
import java.sql.*;
//JDBC : java Database Connectivity
//java ��� <==== Driver[�뿪��] =====> DB sql ���
//JDBC DRIVER�� �ٿ�ε� �޾ƾ��Ѵ�. => DBMS���� �����Ǵ�
public class MemoCreate {

	public static void main(String[] args) {
		// 1. ����̹� �ε�
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success...");
		// 2. DB����
		String url="jdbc:mysql://localhost:3306/schooldb?characterEncoding=UTF-8";
					//��������:dbms����://host:port/database
		String user="root",pwd="multi123";
		
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("DB���� ����!");
		//3, query �� �ۼ��ϱ�
		String sql="create table if not exists memo("
				+ "idx int auto_increment primary key,"
				+ "name varchar(20) not null,"
				+"msg varchar(100),"
				+"wdate datetime default now() )";
		//4. Statement ��ü ������==> sql���� �����ų �� �ִ� ��ü
		//	PreparedStatement
		Statement stmt=con.createStatement();
		//5. sql�� �����Ű��
		stmt.execute(sql);
		System.out.println("Memo���̺� ���� ����(���̺��� �� �ѹ��� ���� �����ؿ�!)");
		//6. db �������� ����
		stmt.close();
		con.close();
		
	}catch(ClassNotFoundException e) {
		System.out.println("����̹� �ε� ����:"+e);
		
	}catch(SQLException e) {
		e.printStackTrace();
	}

}
}
