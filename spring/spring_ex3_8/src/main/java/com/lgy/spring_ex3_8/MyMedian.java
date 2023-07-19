package com.lgy.spring_ex3_8;

public class MyMedian {
	private Median median;
	private int x;
	private int y;
	private int z;
	
	public void pc() {
		median.process(x, y, z);
	}

	public Median getMedian() {
		return median;
	}

	public void setMedian(Median median) {
		this.median = median;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	
}
