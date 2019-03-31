package com.imooc.o2o.dto;

import com.imooc.o2o.entity.Product;
import com.imooc.o2o.enums.ProductStateEnum;

import java.util.List;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-03-31 20:34
 */
public class ProductExecution {
    private int state;
    private String stateInfo;

    // 商品数量
    private int count;

    private Product product;

    private List<Product> productList;

    public ProductExecution() {
    }

    public ProductExecution(ProductStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public ProductExecution(ProductStateEnum stateEnum, Product product) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.product = product;
    }

    public ProductExecution(ProductStateEnum stateEnum, List<Product> productList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.productList = productList;
    }
}
