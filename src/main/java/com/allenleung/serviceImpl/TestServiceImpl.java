package com.allenleung.serviceImpl;

import com.allenleung.dao.TestMapper;
import com.allenleung.entity.Test;
import com.allenleung.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Ly on 2015/10/28.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED) //事务控制
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper dao;

    @Override
    public String print(int id) {
        Test test = dao.selectByPrimaryKey(id);
        return test.getContent();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED) //事务控制
    public void updateContent(int id, String content) {
        Test test = dao.selectByPrimaryKey(id);
        test.setContent(content);
        dao.updateByPrimaryKeySelective(test);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED) //事务控制
    public void newContent(int id, String content) {
//        test.setId(id);
//        dao.insertByAutoGenerateId(test);

        Test test = new Test();
        content = "abc";
        test.setContent(content);
        dao.insertByAutoGenerateId(test);

        test = new Test();
        content = "efgefgefgefgefgefgefgefgefgefgefgefgefgefgefgefg";
        test.setContent(content);
        dao.insertByAutoGenerateId(test);
    }
}
