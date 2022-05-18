package com.kitten.Model;

import javax.swing.*;

/**
 * @author 27213
 */
public interface RightAnimal {

    /**
     * 交换动物
     * @param i 下标
     * @param game
     * @param restartList
     */
    public void rightExchange(int i, JPanel game, RestartList restartList);

    /**
     * 判断前面是否为null
     * @param lastLabel
     * @param animal
     * @param i
     * @param lastPanel
     * @param end
     * @param restartList
     */
    public void isLabel(JLabel lastLabel, Animal animal, int i, JPanel lastPanel, int end, RestartList restartList);

    /**
     * 左边为null
     * @param frontPanel
     */
    public void rightNull(JPanel frontPanel);
}
