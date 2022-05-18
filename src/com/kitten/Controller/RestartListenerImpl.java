package com.kitten.Controller;

import com.kitten.Model.RestartList;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 27213
 */
public class RestartListenerImpl extends MouseAdapter implements RestartListener {
    RestartList restartList;

    public RestartListenerImpl() {}

    public RestartListenerImpl(RestartList restartList) {
        this.restartList = restartList;
    }

    /**
     * 鼠标按下
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        //获取上一步操作
        Object[] pop = restartList.pop();
        JPanel thisPanel = (JPanel) pop[0];
        JPanel otherPanel = (JPanel) pop[1];
        System.out.println("上一步点击的面板"+thisPanel.getName());
        System.out.println("交换之后的面板"+otherPanel.getName());

        //拿到交换之后的label
        JLabel oldLabel = (JLabel) otherPanel.getComponent(0);
        otherPanel.removeAll();
        //重绘
        otherPanel.repaint();
        thisPanel.add(oldLabel);
        //重绘
        thisPanel.repaint();
    }
    @Override
    public void setRestartList(RestartList restartList){
        this.restartList = restartList;
    }
}
