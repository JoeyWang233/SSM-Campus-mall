package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ProductDao;
import com.imooc.o2o.dao.ProductImgDao;
import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductImg;
import com.imooc.o2o.enums.ProductStateEnum;
import com.imooc.o2o.exception.ProductOperationException;
import com.imooc.o2o.service.ProductService;
import com.imooc.o2o.util.ImageUtil;
import com.imooc.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-03-31 20:52
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductImgDao productImgDao;

    // 对图片的处理在这里做
    @Override
    @Transactional
    public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList) throws ProductOperationException {
        // 1.处理缩略图：获取缩略图相对路径并赋值给product
        // 2.向tb_product表中写入商品信息，获取productId
        // 3.结合productId批量处理商品详情图
        // 4.将商品详情图列表批量插入tb_product_img中

        if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
            product.setCreateTime(new Date());
            product.setLastEditTime(new Date());
            // 默认为上架状态
            product.setEnableStatus(1);

            if (thumbnail != null)
                this.addThumbnail(product, thumbnail);

            try {
                int effectedNum = productDao.insertProduct(product);
                if (effectedNum <= 0)
                    throw new ProductOperationException("创建商品失败");
            } catch (Exception e) {
                throw new ProductOperationException("商品创建失败：" + e.toString());
            }

            // 添加商品详情图
            if (productImgHolderList != null && productImgHolderList.size() > 0)
                this.addProductImgList(product, productImgHolderList);

            return new ProductExecution(ProductStateEnum.SUCCESS, product);
        } else {
            return new ProductExecution(ProductStateEnum.EMPTY);
        }
    }

    /**
     * @Description: 批量添加详情图片
     * @Param: [product, productImgHolderList]
     * @return: void
     * @Author: Joey
     * @Date: 2019/3/31 22:08
     */
    private void addProductImgList(Product product, List<ImageHolder> productImgHolderList) {
        // 获取图片存储路径，这里直接存放在相应店铺的文件夹下
        String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
        List<ProductImg> productImgList = new ArrayList<>();

        for(ImageHolder productImgHolder: productImgHolderList){
            String imgAddr = ImageUtil.generateNormalImg(productImgHolder, dest);
            ProductImg productImg = new ProductImg();

            productImg.setProductId(product.getProductId());
            productImg.setCreateTime(new Date());
            productImg.setImgAddr(imgAddr);

            productImgList.add(productImg);
        }

        if(productImgList.size()>0){
            try {
                int effectedNum = productImgDao.batchInsertProductImg(productImgList);
                if(effectedNum<=0)
                    throw new ProductOperationException("创建商品详情图片失败");
            }catch (Exception e){
                throw new ProductOperationException("创建商品详情图片失败");
            }
        }
    }

    /**
     * @Description: 生成缩略图并将缩略图地址存入product
     * @Param: [product, thumbnail]
     * @return: void
     * @Author: Joey
     * @Date: 2019/3/31 22:08
     */
    private void addThumbnail(Product product, ImageHolder thumbnail) {
        String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
        String thumbnailAddr = ImageUtil.generateThumbnail(thumbnail, dest);
        product.setImgAddr(thumbnailAddr);
    }
}
