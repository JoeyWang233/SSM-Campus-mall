package com.imooc.o2o.dao;

import com.imooc.o2o.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {

    /**
    * @Description: 通过shop id查询店铺商品类别
    * @Param:
    * @return:
    * @Author: Joey
    * @Date: 2019/3/29 10:20
    */
    List<ProductCategory> queryProductCategoryList(Long shopId);
}
