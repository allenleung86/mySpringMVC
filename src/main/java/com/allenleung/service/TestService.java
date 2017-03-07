package com.allenleung.service;

import com.allenleung.dao.TestMapper;
import com.allenleung.entity.Test;
import com.allenleung.exception.ParameterException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Ly on 2015/10/28.
 */
public interface TestService {
    public String print(int id);

    public void updateContent(int id, String content);

    public void newContent(int id, String content);

    public void newContent2(int id, String content);
}
