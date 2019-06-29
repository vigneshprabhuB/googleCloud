package com.test.pol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleDbconnect {
	
	public static void main(String aString[]) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection=java.sql.DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMS","postgres","admin");
		PreparedStatement ps=connection.prepareStatement("select loc_id,login_id,password from base.m_user");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			
			System.out.println(rs.getArray(2));
		}
	}

}
