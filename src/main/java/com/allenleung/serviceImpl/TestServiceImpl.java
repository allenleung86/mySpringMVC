package com.allenleung.serviceImpl;

import com.allenleung.dao.TestMapper;
import com.allenleung.entity.Test;
import com.allenleung.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created by Ly on 2015/10/28.
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper dao;

    @Override
    public String print(int id) {
        Test test = dao.selectByPrimaryKey(id);
        return test.getContent();
    }

    @Override
    public void updateContent(int id, String content) {
        Test test = dao.selectByPrimaryKey(id);
        test.setContent(content);
        dao.updateByPrimaryKeySelective(test);
    }

    @Override
    public void newContent(int id, String content) {
        Test test = new Test();
        test.setId(id);
        test.setContent(content);
        dao.insertSelective(test);
    }
}
