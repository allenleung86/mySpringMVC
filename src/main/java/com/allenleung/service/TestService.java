package com.allenleung.service;

import com.allenleung.dao.TestMapper;
import com.allenleung.entity.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Ly on 2015/10/28.
 */
@Service
public class TestService {
    @Resource
    TestMapper dao;
    public String print(int id) {
        Test test = dao.selectByPrimaryKey(id);
        return test.getContent();
    }

    public void updateContent(int id, String content) {
        Test test = dao.selectByPrimaryKey(id);
        test.setContent(content);
        dao.updateByPrimaryKeySelective(test);
    }

    public void newContent(int id, String content) {
        Test test = new Test();
        test.setId(id);
        test.setContent(content);
        dao.insertSelective(test);
    }
}
