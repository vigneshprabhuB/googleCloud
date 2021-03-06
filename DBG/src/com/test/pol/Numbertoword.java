package com.test.pol;

import java.util.ArrayList;


public class Numbertoword {

public long findNumberOfDigit(Double number){
	int digit=0;
	if(number>0){
	digit=1;
	while(number>=10){
		number=number/10;
		digit=digit+1;
	}
	}
	return digit;	
}	
	
	
	

   public static void main(String a[]){
	
		double number=11112;
		ArrayList<Integer> digitArray=new ArrayList<Integer>();
		ArrayList<Integer> digitArrayMAinOrder=new ArrayList<Integer>();
		Numbertoword numbertoword=new Numbertoword();
		long totalDigits=numbertoword.findNumberOfDigit(number);
		for(int j=0;j<totalDigits;j++){
			digitArray.add((int) Math.floor(number/(Math.pow(10, j)) % 10 ));
		}
		
		System.out.println(digitArray);
		int hundreds=0;
		int thousand=0;
	
		for(int h=0;h<=2;h++){
			if(h<digitArray.size()){
			hundreds=hundreds+(int) (digitArray.get(h)*Math.pow(10, h));
		}
		}
		
		for(int y=3;y<=4;y++){
			if(y<digitArray.size()){
				thousand=thousand+(int) (digitArray.get(y)*Math.pow(10, y-3));
		}	
		}
		
		for(int y=5;y<=6;y++){
			if(y<digitArray.size()){
				thousand=thousand+(int) (digitArray.get(y)*Math.pow(10, y-5));
		}	
		}
		
		for(int y=7;y<=8;y++){
			if(y<digitArray.size()){
				thousand=thousand+(int) (digitArray.get(y)*Math.pow(10, y-7));
		}	
		}
		System.out.println(hundreds);
		System.out.println(thousand);
	}

}
