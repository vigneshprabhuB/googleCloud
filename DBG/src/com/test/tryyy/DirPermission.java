package com.test.tryyy;

import java.util.ArrayList;
import java.util.List;

public class DirPermission {
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("flush" + this);
	}

	List<DirPermission> add = new ArrayList<DirPermission>();

	private void addList(int val) {

		DirPermission dirPermission = new DirPermission();
		dirPermission.setA1(val);
		add.add(dirPermission);
		dirPermission = null;

	}

	public void doSomething(int i) {

		this.addList(i);

	}

	public static void main(String a9[]) {

		int i = 0;
		while (i <= 1000000000) {
			System.out.println(i);
			new DirPermission().doSomething(i);
			i++;
		}
		System.out.println("completed");
	}

	public long getA1() {
		return a1;
	}

	public void setA1(long a1) {
		this.a1 = a1;
	}

	public long getA2() {
		return a2;
	}

	public void setA2(long a2) {
		this.a2 = a2;
	}

	public long getA3() {
		return a3;
	}

	public void setA3(long a3) {
		this.a3 = a3;
	}

	public long getA4() {
		return a4;
	}

	public void setA4(long a4) {
		this.a4 = a4;
	}

	public long getA5() {
		return a5;
	}

	public void setA5(long a5) {
		this.a5 = a5;
	}

	public long getA6() {
		return a6;
	}

	public void setA6(long a6) {
		this.a6 = a6;
	}

	public long getA11() {
		return a11;
	}

	public void setA11(long a11) {
		this.a11 = a11;
	}

	public long getA22() {
		return a22;
	}

	public void setA22(long a22) {
		this.a22 = a22;
	}

	public long getA33() {
		return a33;
	}

	public void setA33(long a33) {
		this.a33 = a33;
	}

	public long getA44() {
		return a44;
	}

	public void setA44(long a44) {
		this.a44 = a44;
	}

	public long getA55() {
		return a55;
	}

	public void setA55(long a55) {
		this.a55 = a55;
	}

	public long getAdr() {
		return adr;
	}

	public void setAdr(long adr) {
		this.adr = adr;
	}

	public long getAdvr() {
		return advr;
	}

	public void setAdvr(long advr) {
		this.advr = advr;
	}

	public long getAvsr() {
		return avsr;
	}

	public void setAvsr(long avsr) {
		this.avsr = avsr;
	}

	public long getAs() {
		return as;
	}

	public void setAs(long as) {
		this.as = as;
	}

	public long getAgs() {
		return ags;
	}

	public void setAgs(long ags) {
		this.ags = ags;
	}

	public long getAv() {
		return av;
	}

	public void setAv(long av) {
		this.av = av;
	}

	public long getAh() {
		return ah;
	}

	public void setAh(long ah) {
		this.ah = ah;
	}

	private long a1;
	private long a2;
	private long a3;

	private long a4;

	private long a5;
	private long a6;
	private long a11;
	private long a22;
	private long a33;
	private long a44;
	private long a55;
	private long adr;
	private long advr;
	private long avsr;
	private long as;
	private long ags;
	private long av;
	private long ah;

}
