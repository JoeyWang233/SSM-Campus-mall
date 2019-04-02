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

    /** 
    * @Description: 删除指定商品下的所有详情图 
    * @Param: [productId] 
    * @return: int
    * @Author: Joey
    * @Date: 2019/4/2 21:30
    */ 
    int deleteProductImgByProductId(long productId);
}
