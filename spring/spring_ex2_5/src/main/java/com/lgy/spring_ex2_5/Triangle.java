package com.lgy.spring_ex2_5;

public class Triangle {
	private int x;
	private int y;
	private int z;
	public void process() {
		if ((x+y) >=z||(y+z) >=x||(x+z) >=y) {
			System.out.println("삼각형이 됩니다.");
		} else {
			System.out.println("삼각형이 안됩니다.");
		}
	}
//	public void process() {
//		if ((x+y >z)||(z+y >x)||(z+x >y)) {
//			System.out.println("삼각형이 됩니다.");
//		} else {
//			System.out.println("삼각형이 안됩니다.");
//		}
//	}
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
