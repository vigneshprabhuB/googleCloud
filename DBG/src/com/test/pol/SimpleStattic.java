package com.test.pol;

public class SimpleStattic {
	
	
	static class a{
		a(){
			System.out.println("INNER CLASSS INTATIATED");
		}
		
		static double pi=3.14;
		static {
			System.out.println(pi);
		}
	}

	
	public static void main(String a[]){
		System.out.println();
		new SimpleStattic.a();
	}

	
}
