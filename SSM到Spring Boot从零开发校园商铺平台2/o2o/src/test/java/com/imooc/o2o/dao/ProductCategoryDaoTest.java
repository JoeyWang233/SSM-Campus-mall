package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-03-29 11:46
 */
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    public ProductCategoryDao productCategoryDao;

    @Test
    public void testQueryByShopId() {
        long shopId = 1;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println(productCategoryList.size());
    }
}
