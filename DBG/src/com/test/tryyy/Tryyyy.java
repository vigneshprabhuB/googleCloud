package com.test.tryyy;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class Tryyyy {

	public static void main(String a[]) throws IOException {
	try {
			Socket socket=new Socket("localhost",8080);
			InputStream is=socket.getInputStream();
			int charr=0;
			String reString="";
			while((charr=is.read())!=-1){
				reString=reString+(char)charr;
			}
			System.out.println(reString);
		} catch (Exception e){ 
			e.printStackTrace();
		}
	}}

