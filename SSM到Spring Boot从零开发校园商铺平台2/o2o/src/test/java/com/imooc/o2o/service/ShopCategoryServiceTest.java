package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-04-20 23:17
 */
public class ShopCategoryServiceTest extends BaseTest {
    @Autowired
    private ShopCategoryService shopCategoryService;

    @Test
    public void testgetShopCategoryList(){
        ShopCategory shopCategoryCondition = new ShopCategory();
        shopCategoryCondition.setParent(new ShopCategory(12L));
        List<ShopCategory> shopCategoryList = shopCategoryService.getShopCategoryList(shopCategoryCondition);
        System.out.println(shopCategoryList);
    }
}
