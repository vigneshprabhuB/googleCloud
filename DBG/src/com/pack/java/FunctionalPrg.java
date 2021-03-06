package com.pack.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class FunctionalPrg {
	public static void main(String[] args) {
		
		List<Person>list=new ArrayList<Person>();
		Person person=new Person();
		person.setPersonSortName("Bnbu");
		person.setAge(110);
		person.setUser(new User("Vignesh"));
		
		Person person1=new Person();
		person1.setPersonSortName("Babu");
		person1.setAge(110);
		person1.setUser(new User("Az"));
		
		Person person2=new Person();
		person2.setPersonSortName("Ca");
		person2.setAge(121);
		person2.setUser(new User("a"));
		list.add(person);
		list.add(person1);
		list.add(person2);

//		Collections.sort(list,Comparator.comparing(new Comparator() {
//		}).);
//		System.out.println(list);
		

	}

}

class Person{
	private String personSortName;
	private int age;
	private User user;
	public String getPersonSortName() {
		return personSortName;
	}
	public void setPersonSortName(String personSortName) {
		this.personSortName = personSortName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


}
class User{
	User(String user){
		this.userName=user;
	}
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}

@FunctionalInterface
interface Numeric {
	int i=0;
	public void getNumber(int i );
	public default void display(){
		System.out.println(i);
	}
}