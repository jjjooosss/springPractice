package com.lgy.spring_join.service;

import com.lgy.spring_join.dao.EmpInfoDao;
import com.lgy.spring_join.dto.EmpDeptDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class EmpinfoServiceImpl implements EmpinfoService {

    @Autowired
    private SqlSession sqlSession;
    @Override
    public ArrayList<EmpDeptDto> list() {
        log.info("@# EmpinfoServiceImpl.list()");
        EmpInfoDao dao = sqlSession.getMapper(EmpInfoDao.class);
        ArrayList<EmpDeptDto> list = dao.list();
        return list;
    }
}
