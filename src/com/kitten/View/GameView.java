package com.kitten.View;

import com.kitten.Model.RestartList;

import javax.swing.*;
import java.awt.*;

/**
 * @author 27213
 */
public interface GameView {

    /**
     * 游戏活动的交换面板
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     * @return
     */
    public JPanel getGamePanel(int x, int y, int width, int height, Color color);

    /**
     * 一个动物表示的面板，
     * 这里我用一个框表示，交换的话，之交换里面的内容
     * 但是由于上面的也是返回面板，所以我只写一个方法
     * 下面的的方法不使用，提供一个思路
     * @return
     */
    public JPanel getGameSevenPanel();

    /**
     * 获取标签
     * @param str
     * @return
     */
    public JLabel getJLabel(String str);

    /**
     * 获取史迪奇的label
     * @return
     */
    public JLabel getStitch();

    /**
     * 获取猫的label
     * @return
     */
    public JLabel getHelloKitty();

    /**
     * 显示游戏界面
     * @param gamePanel
     * @param gameView
     * @param restartList
     */
    public void setGameView(JPanel gamePanel, GameView gameView, RestartList restartList);

    /**
     * 清除之前的label，并设置新的面板
     * @param gamePanel
     * @param label
     * @param jButton
     */
    public void removeLabel(JPanel gamePanel, JLabel label,JButton jButton);

    /**
     * 清除7个小面板，重新布置新的面板；//重新开始
     * @param gamePanel
     */
    public void removeLabel(JPanel gamePanel);

    /**
     * 获取7个小面板
     * @param gameJPanel
     * @return
     */
    public Component[] getAnimalPanel(JPanel gameJPanel);
}
