package com.kitten.Controller;

import com.kitten.Model.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 27213
 */
public class GameMouseAdapter extends MouseAdapter  {

    /**
     * 当前游戏面板
     */
    JPanel gamePanel;
    /**
     * 存储操作过程
     */
    RestartList restartList;

    public GameMouseAdapter() {}

    public GameMouseAdapter(JPanel gamePanel, RestartList restartList) {
        this.gamePanel = gamePanel;
        this.restartList = restartList;
    }

    /**
     * 单击并释放
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        JPanel jPanel = (JPanel) e.getComponent();
        try{
            JLabel jLabel= (JLabel) jPanel.getComponent(0);
            int i = Integer.parseInt(jLabel.getName());
            System.out.println("你点击的面板name是----"+i);
            if(i==1||i==2||i==3){
                LeftAnimal leftAnimal = new LeftAnimalImpl();
                leftAnimal.leftExchange(i,gamePanel,restartList);
            }else if(i==5||i==6||i==7){
                RightAnimal rightAnimal = new RightAnimalImpl();
                rightAnimal.rightExchange(i,gamePanel,restartList);
            }
        }catch (ArrayIndexOutOfBoundsException w){}
    }

    /**
     * 鼠标按下
     * 作为日志记录
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        System.out.println("手动分割---------------------------------");
        /**
         * 获取点击的面板
         * 获取面板里的是什么标签，是kitty还是史迪奇
         */
        JPanel jPanel = (JPanel)e.getComponent();
        try {
            JLabel jLabel = (JLabel)jPanel.getComponent(0);
            if(jLabel.getName().equals("1")||jLabel.getName().equals("2")||jLabel.getName().equals("3")){
                System.out.println("点击了HelloKitty");
            }else if(jLabel.getName().equals("5")||jLabel.getName().equals("6")||jLabel.getName().equals("7")) {
                System.out.println("点击了史迪奇");
            }
        }catch (ArrayIndexOutOfBoundsException w){
            System.out.println("你点击了空白");
        }
    }
}
