package com.lgy.spring_15.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@Data
//@NoArgsConstructor
public class SampleVO {
	private int mno;
	private String firstName;
	private String lastName;
	
	/*
	public void setMno(int mno) {
		this.mno = mno;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMno() {
		return mno;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public SampleVO(int mno, String firstName, String lastName) {
		this.mno = mno;
		this.firstName = firstName;
		this.lastName = lastName;
	}
*/	
}
