package com.book.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 图片压缩到500KB以下
 */
public class PicUtils {

    static Logger logger = LoggerFactory.getLogger(PicUtils.class);

    public static void main(String[] args) {
        PicUtils.commpressPicForScale("E:\\works\\benren.jpg", "E:\\works\\123.jpg", 500, 0.8); // 图片小于500kb
    }

    /**
     * 根据指定大小和指定精度压缩图片
     *  @param srcPath 源图片地址
     *  @param desPath 目标图片地址
     *  @param desFileSize 指定图片大小，单位kb
     *  @param accuracy 精度，递归压缩的比率，建议小于0.9
     *  @return
     */
    public static String commpressPicForScale(String srcPath, String desPath,
                                              long desFileSize, double accuracy) {
        if (StringUtils.isBlank(srcPath)) {
            return null;
        }
        if (!new File(srcPath).exists()) {
            return null;
        }
        try {
            File srcFile = new File(srcPath);
            long srcFileSize = srcFile.length();
            logger.info("源图片：" + srcPath + "，大小：" + srcFileSize / 1024 + "kb");
             // 1、先转换成jpg
            Thumbnails.of(srcPath).scale(1f).toFile(desPath);
             // 递归压缩，直到目标文件大小小于desFileSize
            commpressPicCycle(desPath, desFileSize, accuracy);

            File desFile = new File(desPath);


            logger.info("目标图片：" + desPath + "，大小" + desFile.length() / 1024 + "kb");
            logger.info("图片压缩完成！");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return desPath;
    }

    private static void commpressPicCycle(String desPath, long desFileSize, double accuracy) throws IOException {
        File srcFileJPG = new File(desPath);
        long srcFileSizeJPG = srcFileJPG.length();
          // 2、判断大小，如果小于500kb，不压缩；如果大于等于500kb，压缩
        if (srcFileSizeJPG <= desFileSize * 1024) {
            return;
        }
         // 计算宽高
        BufferedImage bim = ImageIO.read(srcFileJPG);
        int srcWdith = bim.getWidth();
        int srcHeigth = bim.getHeight();
        int desWidth = new BigDecimal(srcWdith).multiply(new BigDecimal(accuracy)).intValue();
        int desHeight = new BigDecimal(srcHeigth).multiply(new BigDecimal(accuracy)).intValue();
        Thumbnails.of(desPath).size(desWidth, desHeight).outputQuality(accuracy).toFile(desPath);
        commpressPicCycle(desPath, desFileSize, accuracy);
    }
}
