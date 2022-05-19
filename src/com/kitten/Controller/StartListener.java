package com.kitten.Controller;

import com.kitten.Model.Music;
import com.kitten.Model.RestartList;
import com.kitten.View.GameView;
import com.kitten.View.GameViewImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 27213
 */
public class StartListener implements ActionListener {
    /**
     * 声明全局变量
     */
    JPanel gamePanel;
    JLabel label;
    GameView gameView;
    JButton ready;
    RestartList restartList;
    /**
     * 无参构造
     * @return
     */
    public StartListener() {}
    /**
     * 有参构造
     * @return
     */
    public StartListener(JPanel gamePanel, JLabel label, GameView gameView, JButton ready, RestartList restartList) {
        this.gamePanel = gamePanel;
        this.label = label;
        this.gameView = gameView;
        this.ready = ready;
        this.restartList = restartList;
    }

    /**
     * 监听器
     * 监听开始/重新开始按钮
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        String start = "开始";
        String restart = "重新开始";
        gameView = new GameViewImpl();
        if(actionCommand.equals(start)){
            gameView.removeLabel(gamePanel,label,ready);
            gameView.setGameView(gamePanel, this.gameView,restartList);
            System.out.println("点击了开始");
            new Thread(() -> new Music().playMusic()).start();
        }else if(actionCommand.equals(restart)){
            gameView.removeLabel(gamePanel);
            gameView.setGameView(gamePanel, this.gameView,restartList);
            System.out.println("点击了重新开始");
            //清空操作
            restartList.remove();
        }
    }
}
