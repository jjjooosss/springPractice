package com.lgy.spring_mvc_board_std.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Criteria {
	private int pageNum;//페이지 번호
	private int amount;//페이지당 글 갯수

	private String type;
	private String keyword;
	
	public Criteria() {
//		초기페이지는 1이고, 10개씩 출력
//		@AllArgsConstructor 에서 생성자 매개변수가 4개라서 오류->2개의 매개변수를 갖는 생성자 추가 필요
		this(1, 10);//1~10
//		2:11~, 3:21~, 4:31~
//		this(5, 10);//41~50
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	public String[] getTypeArr(){
//		type 이 없으면 빈 스트링 객체(기본 목록 조회), 있으면 분리
		return type == null ? new String[] {}: type.split("");
	}
}











