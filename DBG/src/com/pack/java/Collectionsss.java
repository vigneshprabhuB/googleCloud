package com.pack.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collectionsss {

	public static void main(String[] args) {
      
		
     List<Emp>itt=new ArrayList<Emp>();
     itt.add(new Emp(1,"y"));
     itt.add(new Emp(5,"h"));
     itt.add(new Emp(7,"B"));
     itt.add(new Emp(8,"a"));
     itt.add(new Emp(2,"a"));
     itt.add(new Emp(3,"d"));
     itt.add(new Emp(6,"e"));
     Comparator<Emp>idCmp=(c1,c2)->{return c1.getEmpId()-c2.getEmpId();};
     Comparator<Emp>nameCmp=(c1,c2)->{return c1.getEmpName().compareTo(c2.getEmpName());};
     Collections.sort(itt,idCmp.thenComparing(nameCmp));
     System.out.println(itt);
	}
}

class Emp {
	private int empId;
	private String empName;

	Emp(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
}
