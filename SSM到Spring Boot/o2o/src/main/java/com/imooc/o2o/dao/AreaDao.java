package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Area;

import java.util.List;

public interface AreaDao {

    /** 
    * @Description: 列出区域列表 
    * @Param: [] 
    * @return: java.util.List<com.imooc.o2o.entity.Area> 
    * @Author: Joey
    * @Date: 2019/2/22 
    */
    List<Area> queryArea();
}
