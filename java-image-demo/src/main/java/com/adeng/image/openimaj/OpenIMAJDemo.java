package com.adeng.image.openimaj;

import com.adeng.image.awt.JavaAwtDemo;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.math.geometry.point.Point2d;
import org.openimaj.math.geometry.point.Point2dImpl;
import org.openimaj.math.geometry.shape.Polygon;

import java.io.File;
import java.util.Arrays;

/**
 * @author hzwengcheng 2019-04-25 14:30
 */
public class OpenIMAJDemo {


    public static void main(String[] args) throws Exception {

        // 1. 加载图片
        String path = JavaAwtDemo.class.getClassLoader().getResource("image.png").getPath();
        MBFImage image = ImageUtilities.readMBF(new File(path));

        // 2. 编辑图像
        Point2d tl = new Point2dImpl(10, 10);
        Point2d bl = new Point2dImpl(10, image.getHeight() - 10);
        Point2d br = new Point2dImpl(image.getWidth() - 10, image.getHeight() - 10);
        Point2d tr = new Point2dImpl(image.getWidth() - 10, 10);
        Polygon polygon = new Polygon(Arrays.asList(tl, bl, br, tr));

        image.drawPolygon(polygon, 4, new Float[] { 0f, 0f, 255.0f });

        // 3. 显示图像
        DisplayUtilities.display(image);
    }
}
