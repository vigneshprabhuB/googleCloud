package com.test.pol;

import java.util.HashMap;
import java.util.HashSet;

public class Localleee {

	private String country;
	private String gen;
	
	public Localleee(String country,String gen){
		
		this.country=country;
		this.gen=gen;
	}
	public Localleee() {
		// TODO Auto-generated constructor stub
	}
	public String getCountry(){
		HashMap<String, String> countries=new HashMap<String, String>();
		countries.put("us", "UNITED STATES OF AMERICA");
		countries.put("in", "INDIA");
        return countries.get(this.country);
	}
	
	public String getGenderPop(){
		HashMap<String, String> gender=new HashMap<String, String>();
		gender.put("men", "10000");
		gender.put("women", "010100");
        return gender.get(this.gen);
	}
}
