package com.kitten.View;

import javax.swing.*;
import java.awt.*;

/**
 * 按钮视图
 * @author 27213
 */
public class ButtonViewImpl implements ButtonView {

    @Override
    public JPanel getPanel(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBounds(22,20,1140,70);
        jPanel.setBackground(new Color(255, 255, 255));
        return jPanel;
    }
    @Override
    public JButton getButtonReady(int x, int y, int width, int height){
        JButton jButton = new JButton();
        Color color = new Color(253, 221, 227);
        jButton.setText("开始");
        jButton.setBounds(x,y,width,height);
        jButton.setBackground(color);
        return jButton;
    }
    @Override
    public JButton getButtonRevocation(){
        JButton jButton = new JButton();
        jButton.setText("撤销");
        jButton.setBounds(730,15,90,40);
        jButton.setBackground(new Color(253, 221, 227));
        return jButton;
    }
}
