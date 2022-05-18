package com.kitten.Model;

import javax.swing.*;

/**
 * @author 27213
 */
public interface LeftAnimal {

    /**
     * 交换动物
     * @param i 本身就是前一个的下标
     * @param game
     * @param restartList
     */
    public void leftExchange(int i, JPanel game, RestartList restartList);

    /**
     * 判断label是否为null
     * @param frontLabel
     * @param animal
     * @param i
     * @param frontPanel
     * @param end
     * @param restartList
     */
    public void isLabel(JLabel frontLabel, Animal animal, int i, JPanel frontPanel, int end, RestartList restartList);

    /**
     * 右边为null
     * @param frontPanel
     */
    public void leftNull(JPanel frontPanel);
}
