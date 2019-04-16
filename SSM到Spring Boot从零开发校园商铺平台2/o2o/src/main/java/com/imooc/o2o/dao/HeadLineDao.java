package com.imooc.o2o.dao;

import com.imooc.o2o.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HeadLineDao {
    /** 
    * @Description: 根据传入的查询条件查询头条，传入的查询条件有：enableStatus:是否允许在前端展示页面展示
    * @Param: [headLineCondition] 
    * @return: java.util.List<com.imooc.o2o.entity.HeadLine> 
    * @Author: Joey
    * @Date: 2019/4/13 13:44
    */ 
    List<HeadLine> queryHeadLine(@Param("headLineCondition")HeadLine headLineCondition);
}
