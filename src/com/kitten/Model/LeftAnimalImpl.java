package com.kitten.Model;

import javax.swing.*;

/**
 * @author 27213
 */
public class LeftAnimalImpl implements LeftAnimal{

    JPanel thisJpanel;
    Animal animal;

    @Override
    public void leftExchange(int i, JPanel game, RestartList restartList){
        //当前下标的前两个下标，因为中间有两个就不能换；
        int end;
        animal = new AnimalImpl(game,restartList);
        //获取现在的面板
        thisJpanel = animal.getJpanel(i);
        int thisName = Integer.parseInt(thisJpanel.getName());
        System.out.println("当前的面板name是"+thisName);
        //获取前面的面板
        Object[] panelLabel= animal.getPanelLabel(animal, thisName);
        i = thisName+1;
        System.out.println("前面的面板name"+((JPanel) panelLabel[0]).getName());
        isLabel((JLabel)panelLabel[1],animal,thisName,(JPanel) panelLabel[0],i,restartList);
    }

    @Override
    public void isLabel(JLabel frontLabel, Animal animal, int i, JPanel frontPanel, int end, RestartList restartList){
        if(end<=i){
            return;
        }else {
            if(frontLabel!=null){
                System.out.println("前面有动物");
                Object[] panelLabel = animal.getPanelLabel(animal, ++i);
                System.out.println("现在点击的面板名字"+"i");
                isLabel((JLabel)panelLabel[1],animal,--i,(JPanel) panelLabel[0],end,restartList);
            }else {
                Object[] objects = new Object[2];
                //保存当前面板
                objects[0] = thisJpanel;
                //保存要交换的面板
                objects[1] = frontPanel;
                //保存步骤
                restartList.push(objects);
                //执行交换
                leftNull(frontPanel);
            }
        }
    }

    @Override
    public void leftNull(JPanel frontPanel){
        animal.isNull(frontPanel,thisJpanel);
    }
}
