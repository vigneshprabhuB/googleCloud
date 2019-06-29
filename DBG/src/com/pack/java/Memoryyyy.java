package com.pack.java;

import java.util.ArrayList;

public class Memoryyyy {
	
	public static void main(String[] args) {
		ArrayList<Integer>a=new ArrayList<Integer>();
		a.add(1);
		ArrayList<Integer>b=(ArrayList<Integer>) a.clone();
		b.add(2);
		System.out.println(a);
	}
}
