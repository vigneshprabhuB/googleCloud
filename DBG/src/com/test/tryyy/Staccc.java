package com.test.tryyy;

import java.io.IOException;
import java.util.Random;

public class Staccc {

	public static void main(String arg[]) throws IOException {

		Random random = new Random();
		String ranDomChar = "1890234567";
		
        String ranDomOut="";
		while(ranDomOut.length()<6){
			ranDomOut=ranDomOut+ranDomChar.charAt(random.nextInt(ranDomChar.length()-1));
		}
		System.out.println(ranDomOut);
	}

}
