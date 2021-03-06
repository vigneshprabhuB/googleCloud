package com.pack.java;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Concurrrenrr {
	public static void main(String[] args) throws InterruptedException {

		ArrayList<Integer> integers = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			integers.add(i);
		}

		Runnable r1 = () -> {

			ListIterator<Integer> it = integers.listIterator();
			while (it.hasNext()) {
				System.out.println(it.next());
				integers.add(0);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Runnable r2 = () -> {
			ListIterator<Integer> it2 = integers.listIterator();
			while (it2.hasNext()) {
				integers.remove(it2.nextIndex() - 1);
			//	System.out.println(it2.next());

			}
		};
		
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t1.start();
//		t2.start();
		
		
	}
}
