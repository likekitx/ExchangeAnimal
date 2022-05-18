package com.kitten.View;

import com.kitten.Controller.GameMouseAdapter;
import com.kitten.Model.RestartList;

import javax.swing.*;
import java.awt.*;

/**
 * @author 27213
 */
public class GameViewImpl implements GameView {

    JPanel gameJPanel;
    GameMouseAdapter gameMouseAdapter;
    RestartList restartList;

    @Override
    public JPanel getGamePanel(int x, int y, int width, int height, Color color){
        gameJPanel = new JPanel();
        gameJPanel.setLayout(null);
        gameJPanel.setBounds(x,y,width,height);
        gameJPanel.setBackground(color);
        return gameJPanel;
    }

    @Override
    public JPanel getGameSevenPanel() {
        return null;
    }

    @Override
    public JLabel getJLabel(String str){
        JLabel jLabel = new JLabel(str);
        jLabel.setSize(100,50);
        return jLabel;
    }
    @Override
    public JLabel getStitch(){
        JLabel stitchIcon = new JLabel();
        stitchIcon.setBounds(0,95,140,140);
        ImageIcon stitch = new ImageIcon("src/img/stitch.jpg");
        stitch.setImage(stitch.getImage().getScaledInstance(140,140, Image.SCALE_SMOOTH));
        stitchIcon.setIcon(stitch);
        return stitchIcon;
    }
    @Override
    public JLabel getHelloKitty(){
        JLabel helloKittyIcon = new JLabel();
        helloKittyIcon.setBounds(0,95,140,140);
        ImageIcon kitty = new ImageIcon("src/img/hellokitty.jpg");
        kitty.setImage(kitty.getImage().getScaledInstance(140,140, Image.SCALE_SMOOTH));
        helloKittyIcon.setIcon(kitty);
        return helloKittyIcon;
    }

    @Override
    public void setGameView(JPanel gamePanel, GameView gameView, RestartList restartList){
        //设置第一个位置
        JPanel gamePanel1 = gameView.getGamePanel(35, 50, 140, 330,new Color(255, 255, 255));
        //后续
        JPanel gamePanel2 = gameView.getGamePanel(190, 50, 140, 330,new Color(255, 255, 255));
        JPanel gamePanel3 = gameView.getGamePanel(345, 50, 140, 330,new Color(255, 255, 255));
        JPanel gamePanel4 = gameView.getGamePanel(500, 50, 140, 330,new Color(255, 255, 255));
        JPanel gamePanel5 = gameView.getGamePanel(655, 50, 140, 330,new Color(255, 255, 255));
        JPanel gamePanel6 = gameView.getGamePanel(810, 50, 140, 330,new Color(255, 255, 255));
        JPanel gamePanel7 = gameView.getGamePanel(965, 50, 140, 330,new Color(255, 255, 255));
        /**
         * 添加名字，打上标记，
         */
        gamePanel1.setName("1");
        gamePanel2.setName("2");
        gamePanel3.setName("3");
        gamePanel4.setName("4");
        gamePanel5.setName("5");
        gamePanel6.setName("6");
        gamePanel7.setName("7");
        /**
         * 添加标签显示动物
         */
        JLabel j1 = getHelloKitty();
        JLabel j2 = getHelloKitty();
        JLabel j3 = getHelloKitty();
        j1.setName("1");
        j2.setName("2");
        j3.setName("3");
        JLabel s1 = getStitch();
        JLabel s2 = getStitch();
        JLabel s3 = getStitch();
        s1.setName("5");
        s2.setName("6");
        s3.setName("7");
        gamePanel1.add(j1);
        gamePanel2.add(j2);
        gamePanel3.add(j3);
        gamePanel5.add(s1);
        gamePanel6.add(s2);
        gamePanel7.add(s3);
        /**
         * 添加适配器，监听
         */
        gameMouseAdapter = new GameMouseAdapter(gamePanel,restartList);

        gamePanel1.addMouseListener(gameMouseAdapter);
        gamePanel2.addMouseListener(gameMouseAdapter);
        gamePanel3.addMouseListener(gameMouseAdapter);
        gamePanel4.addMouseListener(gameMouseAdapter);
        gamePanel5.addMouseListener(gameMouseAdapter);
        gamePanel6.addMouseListener(gameMouseAdapter);
        gamePanel7.addMouseListener(gameMouseAdapter);
        //添加面板
        gamePanel.add(gamePanel1);
        gamePanel.add(gamePanel2);
        gamePanel.add(gamePanel3);
        gamePanel.add(gamePanel4);
        gamePanel.add(gamePanel5);
        gamePanel.add(gamePanel6);
        gamePanel.add(gamePanel7);
        gamePanel.revalidate();
    }
    @Override
    public void removeLabel(JPanel gamePanel, JLabel label, JButton jButton){
        gamePanel.remove(label);
        gamePanel.repaint();
        jButton.setText("重新开始");
    }
    @Override
    public void removeLabel(JPanel gamePanel){
        gamePanel.removeAll();
        gamePanel.repaint();
    }
    @Override
    public Component[] getAnimalPanel(JPanel gameJPanel){
        return gameJPanel.getComponents();
    }
}
