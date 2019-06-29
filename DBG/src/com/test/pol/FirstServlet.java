package com.test.pol;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FirstServlet  {

	public static void main(String a[]) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");// server-name : server-port /
	  Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMS","postgres","admin");
       try{
        PreparedStatement ps=c.prepareStatement("update sal_emp set  pay_by_quarter=? ");
        Array intArray = c.createArrayOf("int", new Integer[] {1,2,3,5});
        ps.setArray(1, intArray);
        ps.executeUpdate();
        
        String selectQerry="select pay_by_quarter from sal_emp limit 1";
        Statement ss= c.createStatement();
        ResultSet rs=ss.executeQuery(selectQerry);
       while (rs.next()) {
    	 Array sssss=  rs.getArray(1);
    	 Integer[]intArray1=(Integer[])sssss.getArray();
    	System.out.println(intArray1.length);
		
	}
               
    
       }catch(Exception e){
    	   System.out.println(e);
       }finally{
    	   if(c!=null){
    	   c.close();
       }}
	}

}
