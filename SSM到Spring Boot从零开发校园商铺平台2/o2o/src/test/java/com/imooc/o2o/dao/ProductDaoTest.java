package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.Shop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-03-31 20:17
 */
public class ProductDaoTest extends BaseTest {
    @Autowired
    private ProductDao productDao;

    @Test
    public void testAInsertProduct(){
        Shop shop1 = new Shop();
        shop1.setShopId(1L);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setShopId(1L);
        productCategory.setProductCategoryId(1L);

        Product product = new Product();

        product.setCreateTime(new Date());
        product.setEnableStatus(1);
        product.setImgAddr("商品缩略图");
        product.setProductCategory(productCategory);
        product.setShop(shop1);
        product.setPriority(20);
        product.setProductName("商品1");
        product.setEnableStatus(1);


        productDao.insertProduct(product);
    }
}
