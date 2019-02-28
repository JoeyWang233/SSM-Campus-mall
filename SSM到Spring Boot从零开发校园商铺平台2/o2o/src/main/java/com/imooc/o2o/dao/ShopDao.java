package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;

public interface ShopDao {
    /**
    * @Description:  新增店铺
    * @Param: [shop]
    * @return: int
    * @Author: Joey
    * @Date: 2019/2/23 16:47
    */
    Shop queryByShopId(long shopId);

    // 返回值为受影响的行数
    int insertShop(Shop shop);

    int updateShop(Shop shop);
}
