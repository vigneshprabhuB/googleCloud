package com.test.pol;

import java.io.IOException;

import java.net.URL;
import java.sql.Connection;

public class ThreadSample {
	
	
	public static void main(String a[]) throws IOException{
		try{
		String urlString="robotnik.no-ip.biz:55555/fms_interface/get_robot_status";
		URL url=new URL(urlString);
		Connection con=(Connection) url.openConnection();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
