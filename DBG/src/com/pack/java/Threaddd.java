package com.pack.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Threaddd {

	public static void main(String[] args) {

		List<Integer> intArray = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			intArray.add(i);
		}
		System.out.println(intArray);
		Threaddd.printIntLessThan(intArray, (i) -> i < 10,i -> System.out.println(i));
		

	}

	public static void printIntLessThan(List<Integer> list,
		Predicate<Integer> predicate, Consumer<Integer> consumer) {
		list.stream().filter(predicate).forEach(consumer); 
	}

}
