package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Product;

public interface ProductDao {
    /** 
    * @Description: 插入商品 
    * @Param: [product] 
    * @return: int 
    * @Author: Joey
    * @Date: 2019/3/31 15:38
    */ 
    int insertProduct(Product product);
    
    /** 
    * @Description: 通过productId查询唯一的商品信息 
    * @Param: [productId] 
    * @return: com.imooc.o2o.entity.Product 
    * @Author: Joey
    * @Date: 2019/4/1 21:15
    */ 
    Product queryProductById(long productId);
    
    /** 
    * @Description: 更新商品信息
    * @Param: [product] 
    * @return: int 
    * @Author: Joey
    * @Date: 2019/4/1 21:18
    */ 
    int updateProduct(Product product);

//
//    /**
//    * @Description: 删除指定商品
//    * @Param: [productId]
//    * @return: int
//    * @Author: Joey
//    * @Date: 2019/4/2 21:34
//    */
//    int deleteProductImgByProductId(long productId);
}
