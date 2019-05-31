package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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

    @Ignore
    @Test
    public void testQueryByShopId() {
        long shopId = 1;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println(productCategoryList.size());
    }

    @Ignore
    @Test
    public void testAddBatchProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setShopId(1L);
        productCategory.setCreateTime(new Date());
        productCategory.setPriority(50);
        productCategory.setProductCategoryName("test");

        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(2L);
        productCategoryList.add(productCategory);
        int num = productCategoryDao.batchInsertProductCategory(productCategoryList);
        System.out.println(num);
    }

    @Ignore
    @Test
    public void testDeleteProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(11L);
        productCategory.setShopId(1L);

        int effectNum = productCategoryDao.deleteProductCategory(productCategory.getProductCategoryId(), productCategory.getShopId());
        System.out.println(effectNum);
    }
}
