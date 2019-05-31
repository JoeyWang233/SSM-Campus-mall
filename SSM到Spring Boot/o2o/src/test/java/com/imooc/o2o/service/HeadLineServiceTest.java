package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.HeadLine;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-04-20 22:07
 */
public class HeadLineServiceTest extends BaseTest {

    @Autowired
    private HeadLineService headLineService;

    @Ignore
    @Test
    public void testHeadLineServiceTest(){
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        try {
            List<HeadLine> headLineList = headLineService.getHeadLineList(headLineCondition);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
