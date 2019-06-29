package com.test.tryyy;

public class Statatic implements Cloneable {

	private int cValue = 5;

	public int hai() {
		return this.cValue;
	}

	public void setVal(int id) {
		this.cValue = id;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public boolean equals(Statatic object){
		if(object.hai()==this.cValue){
			return true;
		}else{
			return false;
		}
	}

	public static void main(String a[]) throws CloneNotSupportedException {

		Statatic statatic = new Statatic();
		Statatic statatic1 = (Statatic) statatic.clone();
		statatic1.setVal(5);

		System.out.println(statatic1.equals(statatic));

	}
}