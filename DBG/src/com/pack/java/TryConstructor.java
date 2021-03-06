package com.pack.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TryConstructor {

	public static void main(String[] args) {

		List<Employee> emplIst = new ArrayList<>();
		Employee e1 = new Employee();
		e1.setId(11);
		e1.setName("Arun");
		e1.setScore(11);
		emplIst.add(e1);
		Employee e2 = new Employee();
		e2.setId(1);
		e2.setName("VArun");
		e2.setScore(1);
		emplIst.add(e2);

		Collections.sort(emplIst, Employee.scoreComparator);
		TryConstructor aaa = new TryConstructor() {
			public void printt() {
				System.out.println("ela");
			}
		};
		aaa.printt();
	}

	public void printt() {
		System.out.println("haiii...");
	}

}

class Employee implements Comparable<Employee> {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	private int id;
	private String name;
	private int score;
	private int salary;

	@Override
	public int compareTo(Employee e) {
		return this.id - e.getId();
	}

	public static Comparator<Employee> scoreComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getScore() - o2.getScore();
		}
	};
}
