package com.lgy.spring_test_member_jdbc.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lgy.spring_test_member_jdbc.dto.MemDto;
import com.lgy.spring_test_member_jdbc.util.Constant;

public class MemDao {
	JdbcTemplate template = null;
	
	public MemDao() {template = Constant.template;}
	
	public int loginCheck(String id, String pw) {
		int re= -1;
		String sql ="select mem_pwd from mvc_member where mem_uid="+id;
		MemDto dto =
				template.queryForObject(sql, new BeanPropertyRowMapper<MemDto>(MemDto.class));
		if (dto != null) {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<MemDto>(MemDto.class));
			re = 1;
		} else {
			
		}
	}
	
}
