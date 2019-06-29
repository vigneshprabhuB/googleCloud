package com.pack.java;

import java.security.SecureRandom;

public class Randoom {

	public static void main(String[] args) {
		 String []randomTest={"0","1","2","3","4","5","6","7","8","9"};
		 SecureRandom  randomGen = new SecureRandom (); 
	     String randomString="";
	     for(int i=0;i<6;i++){
	     int randomValue = randomGen.nextInt(randomTest.length);
	     randomString=randomString+randomTest[randomValue];
	     }
	     System.out.println(randomString);
	}
}
