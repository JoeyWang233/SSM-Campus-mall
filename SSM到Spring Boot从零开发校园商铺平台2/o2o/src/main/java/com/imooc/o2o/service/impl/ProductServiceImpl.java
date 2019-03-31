package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ProductDao;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.exception.ProductOperationException;
import com.imooc.o2o.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-03-31 20:52
 */
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    // 对图片的处理在这里做
    @Override
    public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList) throws ProductOperationException {
        return null;
    }
}
