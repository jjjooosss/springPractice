package com.lgy.spring_ex2_6;

public class Asterisk {
	private int num;
	public void process() {
		StringBuffer strBuf = new StringBuffer();
		
		for (int i = num; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				strBuf.append("*");
			}
			strBuf.append("\n");
		}
		System.out.println(strBuf);
	}
//	public void process() {
//		for (int i = num; i > 0; i--) {
//			for (int j = 0; j < i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
