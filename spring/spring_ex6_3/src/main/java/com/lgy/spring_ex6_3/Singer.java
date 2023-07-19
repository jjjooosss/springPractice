package com.lgy.spring_ex6_3;

import java.util.ArrayList;

public class Singer {
	private String name;
	private int member;
	private ArrayList<String> songs;
	
	
	
	public Singer(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	public ArrayList<String> getSongs() {
		return songs;
	}
	public void setSongs(ArrayList<String> songs) {
		this.songs = songs;
	}
	
	
}
