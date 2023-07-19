package com.lgy.spring_ex2_4;

import java.util.Arrays;

public class Median {
	private int x;
	private int y;
	private int z;
	
//	public void process() {
//		int[] numbers = {x,y,z};
//		Arrays.sort(numbers);
//		int med = numbers[1];
//		System.out.println("입력된 정수가 "+x+"와 "+y+"와 "+z+"의 중간값은 "+med);
//	}
	public void process() {
		if ((x > y && x < z) || (x > z && x < y) ) {
			System.out.println("입력된 정수가 "+x+"와 "+y+"와 "+z+"의 중간값은 "+x);
		}else if ((y > x && y < z) || (y > z && y < z) ) {
			System.out.println("입력된 정수가 "+x+"와 "+y+"와 "+z+"의 중간값은 "+y);
		}else {
			System.out.println("입력된 정수가 "+x+"와 "+y+"와 "+z+"의 중간값은 "+z);
		}
		
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
