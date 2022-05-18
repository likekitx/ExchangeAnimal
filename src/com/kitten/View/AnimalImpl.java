package com.kitten.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author 27213
 */
public class AnimalImpl implements Animal {

    /**
     * 窗体
     */
    JFrame jFrame;
    //窗体面板
    Container contentPane;
    @Override
    public Container getJFrame(){
        //创建一个新窗口
        jFrame = new JFrame();
        //窗口设置位置大小
        jFrame.setBounds(360,240,1200,600);
        //窗口有默认属性，所以获取他的面板
        //设置面板的颜色
        contentPane = jFrame.getContentPane();
        contentPane.setBackground(new Color(139, 176, 210));
        //设置面板的布局
        contentPane.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return contentPane;
    }
}
