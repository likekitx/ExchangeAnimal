package com.kitten.View;

import javax.swing.*;

/**
 * @author 27213
 */
public interface ButtonView {

    /**
     * 按钮面板
     * @return
     */
    public JPanel getPanel();

    /**
     *   开始面板
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
     */
    public JButton getButtonReady(int x,int y,int width,int height);

    /**
     * 撤销按钮
     * @return
     */
    public JButton getButtonRevocation();
}
