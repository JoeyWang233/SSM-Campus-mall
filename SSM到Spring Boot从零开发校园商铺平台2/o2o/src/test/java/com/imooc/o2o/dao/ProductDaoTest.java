package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.Shop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

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
    public void testAInsertProduct() {
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

    @Test
    public void testCQueryProductByProductId() {
        Product product = productDao.queryProductById(1L);
        System.out.println(product);
    }

    @Test
    public void testDUpdateProduct() {
        Product product = new Product();
        ProductCategory pc = new ProductCategory();
        Shop shop = new Shop();
        shop.setShopId(1L);
        pc.setProductCategoryId(2L);
        product.setProductId(1L);
        product.setShop(shop);
        product.setProductName("第二个产品");
        product.setProductCategory(pc);
        // 修改productId为1的商品的名称
        // 以及商品类别并校验影响的行数是否为1
        int effectedNum = productDao.updateProduct(product);
        assertEquals(1, effectedNum);
    }


}
