package com.test.pol;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Pclass {
	public static String CLOUD_MOBILE_NOTIFICATION_SERVER_NAME = "https://fcm.googleapis.com/fcm/send";
	public static String CLOUD_MOBILE_SERVER_AUTHORIZATION_KEY = "key=AAAAdpJIPDM:APA91bF4QiAnrQj4JZBW6PhMlIH2LiyjtUDn0XISwts82BnUqld_uWIau8TQv6SFzE7PfUX97SQjnno3gvY4ShAnPrIl7NNgE-DBbID4m-QpegQys1iYa0ixfhgkNE5VgYDaUruZfXKJ";

	public static void main(String a[]) throws Exception {

		JSONObject objectBody = new JSONObject();
		JSONObject objectNotification = new JSONObject();
		//call name -call status
		objectNotification.put("title", "BM RESOLVED");
		//hospital name ,address,city
		objectNotification.put("body","AC HOSPITAL,209/45B Arumuga Achari Street, Opp,Route bus stand,Udumalpet");
		objectBody.put("to","dWRS_SaZPjk:APA91bFk2HLF_fZoQEJ9ZtHn4qJFnL8Bt1mDBR4ACrn27NsfYEzfKftIKY5081ntdl5-pHwaBPwg2It-u7-NLUilGHhx1D9m3a54C5RlTKvNaERKQibn9V7gT_gj7tF3QKBgdx2y9ZMH");
		objectBody.put("content_available", true);
		objectBody.putOpt("notification", objectNotification);
		objectBody.put("data", new JSONObject());
		new Pclass().sendMobileNotificationToUser(objectBody.toString());
	}

	public void sendMobileNotificationToUser(String messageBody)
			throws Exception {
		try {
			String response="";
			URL url = new URL(Pclass.CLOUD_MOBILE_NOTIFICATION_SERVER_NAME);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			// connection headers
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization",Pclass.CLOUD_MOBILE_SERVER_AUTHORIZATION_KEY);
			con.setDoOutput(true);
			OutputStream os = con.getOutputStream();
			os.write(messageBody.getBytes());
			os.flush();
			os.close();
			InputStream io = con.getInputStream();
			int bytevalue = 0;
			while ((bytevalue = io.read()) != -1) {
				response=response+(char) bytevalue;
			}
		  JSONObject jsonobj = new JSONObject(response);
		  int message_status=jsonobj.getInt("success");
		  if(message_status==1){
			  //sucessfully send the notification
			  System.out.println("sucess");
		  }else{
			  System.out.println("failure");
		  }
			io.close();
		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

}
