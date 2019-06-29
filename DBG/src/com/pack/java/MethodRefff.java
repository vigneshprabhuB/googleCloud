package com.pack.java;

public class MethodRefff {
	
	public void printString(){
		System.out.println("string...");
	}
	
	public static void main(String[] args) {
		PrintString printString=new MethodRefff()::printString;
		printString.print();
	}

}

@FunctionalInterface
interface PrintString{
	public void print();
}
