package com.boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.boot.dto.MemDto;

public interface MemService {
//    ArrayList<MemDto> loginOk(HashMap<String, String> param);
    int loginOk(HashMap<String, String> param);
    void register(HashMap<String, String> param);
}
