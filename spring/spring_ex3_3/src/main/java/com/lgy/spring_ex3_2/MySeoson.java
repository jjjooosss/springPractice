package com.lgy.spring_ex3_2;

public class MySeoson {
	private Seoson seosen;
	private int month;
	
	public void result() {
		seosen.rsltSeason(month);
	}

	public Seoson getSeosen() {
		return seosen;
	}

	public void setSeosen(Seoson seosen) {
		this.seosen = seosen;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	
	
	
}
