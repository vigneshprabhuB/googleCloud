package com.pack.java;

import java.util.Optional;

public class Listt {

	public static void main(String[] args) {
		Optional<Integer> aa = Optional.empty();
		aa = Optional.of(new Integer(5));
		System.out.println(aa.filter((q)-> q==5));

	}

}
