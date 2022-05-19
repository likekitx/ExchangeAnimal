package com.kitten.Model;

import com.kitten.View.GameView;
import com.kitten.View.GameViewImpl;

import javax.swing.*;
import java.awt.*;

/**
 * @author 27213
 */
public class AnimalImpl implements Animal {
    String left = "left";
    String right = "right";
    /**
     * 游戏面板
     */
    JPanel gamePanel;
    /**
     *  7个小面板
     */
    Component[] gamePanelArray;
    /**
     * 保存操作
     */
    RestartList restartList;

    public AnimalImpl() {}

    public AnimalImpl(JPanel gamePanel,RestartList restartList) {
        this.gamePanel = gamePanel;
        this.restartList = restartList;
    }
    @Override
    public JPanel getGameJanel(int index){
        GameView gameView = new GameViewImpl();
        //获取游戏面板里的所有小面板
        gamePanelArray = gameView.getAnimalPanel(gamePanel);
        return (JPanel) gamePanelArray[index];
    }
    @Override
    public JLabel getLabel(JPanel gamePanel)    {
        JLabel jLabel;
        try {
            jLabel = (JLabel) gamePanel.getComponent(0);
        }catch (ArrayIndexOutOfBoundsException w){
            jLabel = null;
        }
        return jLabel;
    }
    @Override
    public JPanel getJpanel(int name){
        JPanel thisPanel;
        Component[] components = this.gamePanel.getComponents();
        for (int i = 0; i < components.length; i++) {
            try{
                thisPanel = (JPanel)components[i];
                JLabel jLabel = (JLabel)thisPanel.getComponent(0);
                if(Integer.parseInt(jLabel.getName())==name){
                    return thisPanel;
                }
            }catch (ArrayIndexOutOfBoundsException a){
            }
        }
        return null;
    }
    @Override
    public Object[] getPanelLabel(Animal animal, int j){
        //获取前面的面板
        JPanel frontJanel = animal.getGameJanel(j);
        JLabel frontLabel = animal.getLabel(frontJanel);
        return new Object[]{frontJanel,frontLabel};
    }

    @Override
    public boolean isTrue() {
        boolean flag = false;
        try{
            if(Integer.parseInt(getLabel(getGameJanel(0)).getName()) ==5&&
                    Integer.parseInt(getLabel(getGameJanel(1)).getName())==6&&
                    Integer.parseInt(getLabel(getGameJanel(2)).getName())==7&&
                    Integer.parseInt(getLabel(getGameJanel(4)).getName())==1&&
                    Integer.parseInt(getLabel(getGameJanel(5)).getName())==2&&
                    Integer.parseInt(getLabel(getGameJanel(6)).getName())==3){
                flag =  true;
            }
        }catch (Exception a){}
        return flag;
    }

    @Override
    public void isNull(JPanel Panel,JPanel thisJpanel){
        //要交换的label
        JLabel oldLabel = (JLabel) thisJpanel.getComponent(0);
        //就的面板里的删除
        thisJpanel.removeAll();
        //重绘
        thisJpanel.repaint();
        //把label添加到新面板
        Panel.add(oldLabel);
        //重绘
        Panel.repaint();
        System.out.println("交换完了");
        if(isTrue()){
            JOptionPane.showMessageDialog(gamePanel,"恭喜通关");
            restartList.remove();
        }
    }
}
