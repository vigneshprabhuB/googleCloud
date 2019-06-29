package com.pack.java;

public class Polymor extends A{

@Override
public void hai(){
	System.out.println("this is c");	
}
public static void main(String[] args) {
	new Polymor().hai();
}
}

class A {

	public void hai(){
		System.out.println("this is Ap");
	}
}