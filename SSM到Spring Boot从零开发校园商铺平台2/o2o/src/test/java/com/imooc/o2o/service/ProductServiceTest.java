package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ProductStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-03-31 22:32
 */
public class ProductServiceTest extends BaseTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testAddProduct() throws FileNotFoundException {
        Product product = new Product();
        Shop shop = new Shop(1L);
        ProductCategory productCategory = new ProductCategory(1L);

        product.setShop(shop);
        product.setProductCategory(productCategory);
        product.setProductName("测试商品1");
        product.setProductDesc("测试商品1");
        product.setPriority(20);
        product.setCreateTime(new Date());
        product.setEnableStatus(ProductStateEnum.SUCCESS.getState());

        // 创建缩略图文件流
        File thumbnailFile = new File("D:\\桌面临时文件\\SSM到Spring Boot从零开发校园商铺平台2\\imageSource\\xiaohuangren.jpg");
        InputStream thumbnailIs = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), thumbnailIs);

        // 创建详情图文件流
        File productImgFile1 = new File("D:\\桌面临时文件\\SSM到Spring Boot从零开发校园商铺平台2\\imageSource\\xiaohuangren.jpg");
        InputStream productImg1Is = new FileInputStream(productImgFile1);
        ImageHolder productImg1 = new ImageHolder(productImgFile1.getName(), productImg1Is);

        File productImgFile2 = new File("D:\\桌面临时文件\\SSM到Spring Boot从零开发校园商铺平台2\\imageSource\\xiaohuangren.jpg");
        InputStream productImg2Is = new FileInputStream(productImgFile2);
        ImageHolder productImg2 = new ImageHolder(productImgFile2.getName(), productImg2Is);

        List<ImageHolder> productImgHolderList = new ArrayList<>();
        productImgHolderList.add(productImg1);
        productImgHolderList.add(productImg2);

        ProductExecution pe = productService.addProduct(product, thumbnail, productImgHolderList);
        assertEquals(ProductStateEnum.SUCCESS.getState(),pe.getState());
    }
}
