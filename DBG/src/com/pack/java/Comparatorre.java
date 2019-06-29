package com.pack.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Comparatorre {

	public static void main(String[] args) {
		List<Employees> employees = new ArrayList<>();
		Employees employees1 = new Employees();
		employees1.setEmpId(11);
		employees1.setEmpSalary(10000);
		employees.add(employees1);

		Employees Employees2 = new Employees();
		Employees2.setEmpId(1);
		Employees2.setEmpSalary(100);
		employees.add(Employees2);
		Collections.sort(employees);
		Collections.sort(employees, Comparatorre.SALARY_SORT());
		System.out.println(employees);
	}

	public static Comparator<Employees> SALARY_SORT() {

		Comparator<Employees> salarySort = new Comparator<Employees>() {

			@Override
			public int compare(Employees o1, Employees o2) {
				
				return (int) (o1.getEmpSalary() - o2.getEmpSalary());
			}
		};
		return salarySort;
	}

}

class Employees implements Comparable<Employees> {
	private int empId;
	private String empName;
	private int empSalary;
	private Date dob;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public int compareTo(Employees o) {

		return this.empId - o.empId;
	}
}
