package com.lgy.spring_ex2_2;

public class SeasonDollar {
	public static void main(String[] args) {
//		의존+주입(Dependency Injection) =DI
		Season season = new Season();
		season.setMonth(9);
		season.process();
		
//		의존+주입(Dependency Injection) =DI
		Won2dollar won2dollar = new Won2dollar();
		won2dollar.setWon(3300);
		won2dollar.process();
	}
}
