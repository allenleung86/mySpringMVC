package com.allenleung.serviceImpl;

import com.allenleung.dao.TestMapper;
import com.allenleung.entity.Test;
import com.allenleung.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ly on 2015/10/28.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED) //事务控制
public class TestServiceImpl2 implements TestService {
    private static final Logger log = Logger.getLogger(TestServiceImpl2.class);

    @Autowired
    TestMapper dao;

    @Override
    public String print(int id) {
        Test test = dao.selectByPrimaryKey(id);
        log.info("into TestServiceImpl2's print()");
        return test.getContent();
    }

    @Override
    public void updateContent(int id, String content) {
        Test test = dao.selectByPrimaryKey(id);
        test.setContent(content);
        dao.updateByPrimaryKeySelective(test);
    }

    /**
     * @Author: 890170
     * @Date: 2017-03-07 15:56
     * @Description: 插入test表
     */
    @Override
    public void newContent(int id, String content) {
        Test test = new Test();
        content = "abc";
        test.setContent(content);
        dao.insertByAutoGenerateId(test);

        test = new Test();
        content = "efg";
        test.setContent(content);
        dao.insertByAutoGenerateId(test);
    }

    /**
     * @Author: 890170
     * @Date: 2017-03-07 15:59
     * @Description: 插入test表
     */
    @Override
    public void newContent2(int id, String content) {
        Test test = new Test();
        content = "abcabc";
        test.setContent(content);
        dao.insertByAutoGenerateId(test);

        test = new Test();
        content = "efgefgefgefgefgefgefgefgefgefgefgefgefgefgefgefg";
        test.setContent(content);
        dao.insertByAutoGenerateId(test);
    }
}
