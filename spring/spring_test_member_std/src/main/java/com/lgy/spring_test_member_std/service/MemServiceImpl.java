package com.lgy.spring_test_member_std.service;

import com.lgy.spring_test_member_std.dao.MemDao;
import com.lgy.spring_test_member_std.dto.MemDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("service")
@Slf4j
public class MemServiceImpl implements MemService{
    @Autowired
    private SqlSession sqlSession;

//    @Override //1.컨트롤러단에서 로그인 분기 처리할 경우
//    public ArrayList<MemDto> loginOk(HashMap<String, String> param) {
//        log.info("@# MemServiceImpl.loginOk() start");
//
//        MemDao dao = sqlSession.getMapper(MemDao.class);
//        ArrayList<MemDto> loginOk = dao.loginOk(param);
//        log.info("@# MemServiceImpl.loginOk() end");
//        return loginOk;
//    }
    @Override
    //서비스단에서 로그인 분기 처리 위해 반환타입 int로 변경
    public int loginOk(HashMap<String, String> param) {
        log.info("@# MemServiceImpl.loginOk() start");

        MemDao dao = sqlSession.getMapper(MemDao.class);
        ArrayList<MemDto> loginOk = dao.loginOk(param);
        String userPwd = param.get("mem_pwd");
        int re = -1;
        if (!loginOk.isEmpty()){
            String queryPwd = loginOk.get(0).getMem_pwd();
            re = (userPwd.equals(queryPwd))? 1:0;
        }
        log.info("@# MemServiceImpl.loginOk() end");
        return re;
    }

    @Override
    public void register(HashMap<String, String> param) {
        log.info("@# MemServiceImpl.register() start");

        MemDao dao = sqlSession.getMapper(MemDao.class);
        dao.register(param);
        log.info("@# MemServiceImpl.register() end");

    }
}
