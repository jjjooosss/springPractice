package com.lgy.spring_test_member_mybatis.dao;

import com.lgy.spring_test_member_mybatis.dto.MemDto;

import java.util.ArrayList;

public interface MemDao {
	ArrayList<MemDto> loginYn(String id);
	void register( String mem_uid,  String mem_pwd,  String mem_name);

}
