package com.lgy.spring_ex3_8;

import java.util.Arrays;

public class Median {
	public void process(int x,int y,int z) {
		int[] arr = {x,y,z};
		Arrays.sort(arr);
		System.out.println("입력된 정수가 "+x+"와 "+y+"와 "+z+"의 중간값은 "+arr[1]);
	}
}
