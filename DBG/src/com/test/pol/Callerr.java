package com.test.pol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Callerr {
	
	
public static void main(String a[]){
	try{
	List<String> importCeid=new ArrayList<String>();
	
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMS","postgres","admin");
	String qerry="";
	//to load the import ceids
	qerry="select ceid from  master.ce_id_pmscheduling";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(qerry);
	while(rs.next()){
		importCeid.add(rs.getString(1));
	}
	//validate if ceid present in the asset hdr table if exist get the data from import table and update 
	for(int i=0;i<importCeid.size();i++){
		String countCheckAssetHdr="select case when a>0 then 'true' else 'false' end from (select count(*) as a from master.asset_hdr where ce_id='"+importCeid.get(i)+"')x";
		Statement s=con.createStatement();
		ResultSet rs2=s.executeQuery(countCheckAssetHdr);
	 while(rs2.next()){
		 String validate_value=rs2.getString(1);
		 if(validate_value.equals("true")){
			 String importData="";
			 importData="select last_pa_comp from  master.ce_id_pmscheduling where ceid='"+importCeid.get(i)+"'"; 
			 Statement s1=con.createStatement();
			 ResultSet rs3=s.executeQuery(importData);
			while(rs3.next()){
				String dateValue=rs3.getString(1);
				SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
				Date pm_last_doneDate=sdf.parse(dateValue);
				SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-mm-dd");
				String pmdate=sdf1.format(pm_last_doneDate);
				String update_date="update master.asset_hdr set pm_last_done_dt = '"+pmdate+"' where ce_id='"+importCeid.get(i)+"'";
				PreparedStatement ps3=con.prepareStatement(update_date);
				
				int update=ps3.executeUpdate();
				if(update>0){
				System.out.println("UPDATE SUCESS   ::"+importCeid.get(i));	
				}
			break;
			}
		 }
		 break;
	 }
	
	}
	
	}catch(Exception e){
		System.out.println("ERROR"+e);
	}
	
}	

}
