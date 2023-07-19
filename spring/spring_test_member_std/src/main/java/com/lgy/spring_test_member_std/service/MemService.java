package com.lgy.spring_test_member_std.service;

import com.lgy.spring_test_member_std.dto.MemDto;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemService {
//    ArrayList<MemDto> loginOk(HashMap<String, String> param);
    int loginOk(HashMap<String, String> param);
    void register(HashMap<String, String> param);
}
