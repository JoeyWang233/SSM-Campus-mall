package com.imooc.o2o.dao;

import com.imooc.o2o.entity.ProductImg;

import java.util.List;

public interface ProductImgDao {
    /** 
    * @Description:  批量添加商品详情图片
    * @Param: [productImgList] 
    * @return: int 
    * @Author: Joey
    * @Date: 2019/3/31 15:39
    */ 
    int batchInsertProductImg(List<ProductImg> productImgList);
}
