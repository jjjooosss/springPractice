package com.lgy.spring_join_resultmap.service;

import com.lgy.spring_join_resultmap.dao.EmpInfoDao;
import com.lgy.spring_join_resultmap.dto.EmpDeptDto;
import com.lgy.spring_join_resultmap.dto.EmpJoinDeptDto;
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
    public ArrayList<EmpJoinDeptDto> list() {
        log.info("@# EmpinfoServiceImpl.list()");
        EmpInfoDao dao = sqlSession.getMapper(EmpInfoDao.class);
        ArrayList<EmpJoinDeptDto> list = dao.list();
        return list;
    }
}
