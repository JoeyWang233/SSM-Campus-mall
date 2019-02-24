package com.imooc.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-02-23 20:18
 */
public class ImageUtil {
    // 动态获取当前classpath路径。用以获取watermark.jpg     目前水印的地址是写死的，本地测试还可以，将来发布到服务器上肯定会报错。
    String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);


    /**
     * @Description: 将 CommonsMultipartFile 转换为 java.io.File
     * @Param: [cFile]
     * @return: java.io.File
     * @Author: Joey
     * @Date: 2019/2/24 14:06
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }
    /**
     * @Description: 处理缩略图，并返回新生成图片的相对路径
     * @Param: [thumbnail, targetAddr]
     * @return: java.lang.String
     * @Author: Joey
     * @Date: 2019/2/24 13:31
     */

    /**
     * 举例：
     * File: /xx/xx/xx/xxx.jpg
     * targetAddr:/a/b/c/
     * realFileName: 20190224142298765
     * extension: .jpg
     * relativeAddr: /a/b/c/20190224142298765.jpg
     * dest: 图片在本地的绝对路径
     */
    public static String generateThumbnail(File thumbnail, String targetAddr){
        String realFileName = getRandomFileName();
        String extension = getFileExtension(thumbnail);
        // 传入进来的目录如果不存在则生成目录
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is :" + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is :" + PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail)
                    .size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("D:\\桌面临时文件\\SSM到Spring Boot从零开发校园商铺平台2\\o2o\\target\\classes\\watermark.jpg")), 0.25f)
                    .outputQuality(0.8f)
                    .toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * @Description: 创建目标路径所涉及的目录。 即若targetAddr:/home/work/xiangze/xxx.jpg  则home work xiangze 三个文件夹需要创建
     * @Param: [targetAddr]
     * @return: void
     * @Author: Joey
     * @Date: 2019/2/24 13:17
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * @Description: 获取输入文件名的扩展名
     * @Param: [thumbnail]
     * @return: java.lang.String
     * @Author: Joey
     * @Date: 2019/2/24 13:14
     */
    private static String getFileExtension(File cFile) {
        String originalFileName = cFile.getName();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * @Description: 生成随机文件名，策略：当前年月日十分秒+五位随机数
     * @Param: []
     * @return: java.lang.String
     * @Author: Joey
     * @Date: 2019/2/24 13:10
     */
    private static String getRandomFileName() {
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    public static void main(String[] args) throws IOException {
        // 获取classpath的绝对路径

        Thumbnails.of(new File("D:\\桌面临时文件\\SSM到Spring Boot从零开发校园商铺平台2\\2017061223273314635.png"))
                .size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("D:\\桌面临时文件\\SSM到Spring Boot从零开发校园商铺平台2\\2017061223273314635.png")), 0.25f)
                .outputQuality(0.8f)
                .toFile("D:\\桌面临时文件\\SSM到Spring Boot从零开发校园商铺平台2\\2017061223273314635new.png");
    }
}
