package com.imooc.o2o.interceptor.Shopadmin;

import com.imooc.o2o.entity.Shop;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: o2o
 * @description: 店家管理系统操作验证，确保在店铺列表中点击“进入店铺”后，session中有“currentShop”属性
 * @author: Joey
 * @create: 2019-06-01 10:49
 */
public class ShopPermissionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
        List<Shop> shopList = (List<Shop>) request.getSession().getAttribute("shopList");
        if(shopList!=null && currentShop!=null){
            for(Shop shop:shopList){
                if(shop.getShopId().equals(currentShop.getShopId())){
                    return true;
                }
            }
        }

        return false;
    }
}
