package com.pack.java;

import java.util.ArrayList;
import java.util.List;

public class EqualssDemo {

	public static void main(String a[]) throws InterruptedException {
		Student s = new Student(1);
		Student s1 = new Student(1);
		System.out.println(s.equals(s1));
		System.out.println(s.hashCode());

		List<Double>listD=new ArrayList<Double>();
		for(int i=0;i<1000000000;i++){
			listD.add(Math.random());
			System.out.println(listD);
		}
		Thread.sleep(10000);

	}

}

class Student {
	public int id;

	Student(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0.getClass().equals(Student.class)) {
			Student student = (com.pack.java.Student) arg0;
			return this.id == student.id;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
