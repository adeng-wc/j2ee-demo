package com.adeng.image.imagej;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

import java.awt.*;

/**
 * @author hzwengcheng 2019-04-25 14:27
 */
public class ImageJDemo {

    public static void main(String[] args) {

        // 1. 加载图片
        ImagePlus imp = IJ.openImage(ImageJDemo.class.getClassLoader().getResource("image.png").getPath());

        // 2. 编辑图像
        ImageProcessor ip = imp.getProcessor();
        ip.setColor(Color.BLUE);
        ip.setLineWidth(4);
        ip.drawRect(10, 10, imp.getWidth() - 20, imp.getHeight() - 20);

        // 3. 显示图像
        imp.show();
    }
}
