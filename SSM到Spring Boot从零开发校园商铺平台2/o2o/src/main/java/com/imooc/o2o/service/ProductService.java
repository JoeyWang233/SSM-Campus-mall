package com.imooc.o2o.service;

import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.exception.ProductOperationException;

import java.util.List;

public interface ProductService {
    /** 
    * @Description: 添加商品信息及缩略图处理
    * @Param: [] 
    * @return: com.imooc.o2o.dto.ProductExecution 
    * @Author: Joey
    * @Date: 2019/3/31 20:35
    */ 
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList) throws ProductOperationException;
}
