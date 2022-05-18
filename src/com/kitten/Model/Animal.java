package com.kitten.Model;

import javax.swing.*;

/**
 * @author 27213
 */
public interface Animal {

    /**
     * 对外提供获取7个面板的方法
     * 根据下标获取面板
     * @param index
     * @return
     */
    public JPanel getGameJanel(int index);

    /**
     * 获取面板的label
     * @param gamePanel
     * @return
     */
    public JLabel getLabel(JPanel gamePanel);

    /**
     * 通过JLabel获取当前的面板,和当前面板的name
     * @param name
     * @return
     */
    public JPanel getJpanel(int name);

    /**
     * 获取前面的label
     * @param animal
     * @param j
     * @return
     */
    public Object[] getPanelLabel(Animal animal, int j);
    /**
     * 判断是否交换完成
     * @return
     */
    public boolean isTrue();

    /**
     * 交换的方法
     * @param Panel
     * @param animal
     * @param thisJpanel
     */
    public void isNull(JPanel Panel,JPanel thisJpanel);
}
