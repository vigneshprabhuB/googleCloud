package com.pack.java;

import java.lang.reflect.Method;

public class Reflectionn {

	private void hai() {
		System.out.println("Hai");
	}
	public void bye(){
		System.out.println("Bye");
	}
	
	public static void main(String[] args) {
		Class<Reflectionn> reflectionn=Reflectionn.class;
		Method []method= reflectionn.getMethods();
		System.out.println(method);
	}
}
