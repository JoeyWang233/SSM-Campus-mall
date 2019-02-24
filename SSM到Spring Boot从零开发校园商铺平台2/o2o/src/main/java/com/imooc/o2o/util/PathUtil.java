package com.imooc.o2o.util;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-02-23 20:52
 */
public class PathUtil {
    private static String separator = System.getProperty("file.separator");

    /**
    * @Description:  获取本地磁盘存放图片的位置的根路径
    * @Param: []
    * @return: java.lang.String
    * @Author: Joey
    * @Date: 2019/2/24 14:17
    */
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath;
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/桌面临时文件/SSM到Spring Boot从零开发校园商铺平台2/image/";
        } else {
            basePath = "/home/xiangze/image";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    public static String getShopImagePath(long shopId) {
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
