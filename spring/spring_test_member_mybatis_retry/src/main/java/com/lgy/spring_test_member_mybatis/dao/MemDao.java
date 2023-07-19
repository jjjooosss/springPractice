package com.lgy.spring_test_member_mybatis.dao;

import com.lgy.spring_test_member_mybatis.dto.MemDto;

import java.util.ArrayList;

public interface MemDao {
    ArrayList<MemDto> loginOk(String id);
    void register(String id, String pw, String name);
}
