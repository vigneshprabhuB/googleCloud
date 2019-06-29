package com.pack.java;

public class Recursion {

	public static void main(String[] args) {
		//System.out.println();
		new Recursion().sumOfValues(5);
	}

	public int sumOfValues(int value) {
		int a=value;
		if (value > 0) {
			value = value + this.sumOfValues(value - 1);
			System.out.println(a);
			return value;
			
		} else {
			return value;
		}
	}

}
