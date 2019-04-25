package com.adeng.image.awt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**
 * @author hzwengcheng 2019-04-25 11:14
 */
public class JavaAwtDemo {

    public static void main(String[] args) throws Exception {

        // 1. 加载图片
        URL imagePath = JavaAwtDemo.class.getClassLoader().getResource("image.png");
        BufferedImage myPicture = ImageIO.read(new File(imagePath.toURI()));

        // 2. 修改图片
        Graphics2D g = (Graphics2D) myPicture.getGraphics();
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLUE);
        g.drawRect(10, 10, myPicture.getWidth() - 20, myPicture.getHeight() - 20);


        // 3. 显示图片
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);
        JFrame f = new JFrame();
        f.setSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()));
        f.add(jPanel);
        f.setVisible(true);
    }
}
