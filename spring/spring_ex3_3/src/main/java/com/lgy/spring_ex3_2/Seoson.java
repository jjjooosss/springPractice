package com.lgy.spring_ex3_2;

public class Seoson {

	public void rsltSeason(int month) {

		switch (month) {
		case 3:case 4:case 5:
			System.out.println("봄");
		case 6:case 7:case 8:
			System.out.println("여름");
			break;
		case 9:case 10:case 11:
			System.out.println("가을");
			break;
		case 12:case 1:case 2:
			System.out.println("겨울");
			break;
		default:
			break;
		}
	}
	
}
