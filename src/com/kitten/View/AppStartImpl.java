package com.kitten.View;

import com.kitten.App;
import com.kitten.Controller.RestartListenerImpl;
import com.kitten.Controller.StartListener;
import com.kitten.Model.RestartList;
import com.kitten.Model.RestartListImpl;

import javax.swing.*;
import java.awt.*;

/**
 * 启动视图的类
 * @author 27213
 */
public class AppStartImpl implements AppStart {

    /**
     * 提供构造方法显示界面
     */
    public AppStartImpl() {
        init();
    }

    /**
     *  窗体里的面板
     */
    ButtonView buttonView;
    GameView gameView;
    JPanel gamePanel;
    JPanel buttonPanel;
    /**
     * 存储操作过程
     */
    RestartList restartList;

    @Override
    public void init(){
        //标砖窗体类
        Animal animal = new AnimalImpl();
        Container jFrame = animal.getJFrame();
        //创建按钮类对象
        buttonView = new ButtonViewImpl();
        //获取按钮面板
        buttonPanel = buttonView.getPanel();
        //标志是开始按钮
        JButton ready = buttonView.getButtonReady(320,15,90,40);
        //获取撤销按钮
        JButton buttonRevocation = buttonView.getButtonRevocation();
        //添加按钮
        buttonPanel.add(ready);
        buttonPanel.add(buttonRevocation);
        //添加面板
        jFrame.add(buttonPanel);
        //获取游戏面板视图
        gameView = new GameViewImpl();
        //设置游戏面板
        gamePanel = gameView.getGamePanel(22, 110, 1140, 430, new Color(241, 219, 219));
        //创建标签
        JLabel label = gameView.getJLabel("动 物 交 换");
        label.setBounds(450,30,500,350);
        label.setFont(new Font("宋体",Font.BOLD,40));
        gamePanel.add(label);
        jFrame.add(gamePanel);
        //设置可见
        jFrame.setVisible(true);

        //存储操作过程的类
        restartList = new RestartListImpl();

        //给按钮设置监听事件
        ready.addActionListener(new StartListener(gamePanel,label,gameView,ready,restartList));
        //添加撤销监听器
        buttonRevocation.addMouseListener(new RestartListenerImpl(restartList));
    }
}
