package com.lgy.spring_ex2_6;

public class Capital {

	private String alphabet;
	
	public void process() {
		StringBuffer strBuf = new StringBuffer();
		char c='A';
		char c2=alphabet.charAt(0);
		
		for (char i = c2; i >= c; i--) {
			for (char j = c; j <= i; j++) {
				strBuf.append(j);
			}
			strBuf.append("\n");
		}
		System.out.println(strBuf);
	}

	public String getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}

	
//	private char alphabet;
//	
//	public void process() {
//		for (char i = alphabet; i >= 'A'; i--) {
//			for (char j = 'A'; j <= i; j++) {
//				System.out.print(j);
//			}
//			System.out.println();
//		}
//	}
//	
//	public char getAlphabet() {
//		return alphabet;
//	}
//	
//	public void setAlphabet(char alphabet) {
//		this.alphabet = alphabet;
//	}
	
}
