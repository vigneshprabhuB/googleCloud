package com.pack.java;

public class Calculatee {
	
	public static void main(String[] args) {
	System.out.println(new Calculatee().convertMinutestoString(137.0));
	}
	
	public String convertMinutestoString(Double min){
		String formated=Integer.toString((int) (min/60))+":"+Integer.toString((int) ((min%60/60)*60));
        return formated;
	}

}
