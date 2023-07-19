package com.lgy.spring_test_item_std.service;

import com.lgy.spring_test_item_std.dao.ItemDao;
import com.lgy.spring_test_item_std.dto.ItemDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@Service("service")
public class ItemServiceImpl implements ItemService{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public ArrayList<ItemDto> list() {
        log.info("@# ItemServiceImpl.list() start");
        ItemDao dao = sqlSession.getMapper(ItemDao.class);
        ArrayList<ItemDto> list = dao.list();

        log.info("@# ItemServiceImpl.list() end");

        return list;
    }

    @Override
    public void write(HashMap<String, String> param) {
        log.info("@# ItemServiceImpl.write() start");
        ItemDao dao = sqlSession.getMapper(ItemDao.class);
        dao.write(param);
        log.info("@# ItemServiceImpl.write() end");
    }
}
