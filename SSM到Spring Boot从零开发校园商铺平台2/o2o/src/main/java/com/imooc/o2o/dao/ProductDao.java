package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Product;

public interface ProductDao {
    /** 
    * @Description: 插入商品 
    * @Param: [product] 
    * @return: int 
    * @Author: Joey
    * @Date: 2019/3/31 15:38
    */ 
    int insertProduct(Product product);
}
