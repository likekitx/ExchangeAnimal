package com.kitten.Model;

import javax.swing.*;

/**
 * @author 27213
 */
public class RightAnimalImpl implements RightAnimal {

    JPanel thisJpanel;
    Animal animal;
    JPanel game;

    @Override
    public void rightExchange(int i, JPanel game, RestartList restartList){
        this.game = game;
        int end;
        animal = new AnimalImpl(game);
        //获取现在的面板
        thisJpanel = animal.getJpanel(i);
        int thisName = Integer.parseInt(thisJpanel.getName());
        System.out.println("当前的面板name"+thisName);
        //拿到前面的面板和label
        thisName -= 2;
        Object[] panelLabel= animal.getPanelLabel(animal, thisName);
        System.out.println("前面的面板name"+((JPanel) panelLabel[0]).getName());
        end = thisName-2;
        isLabel((JLabel)panelLabel[1],animal,thisName,(JPanel) panelLabel[0],end,restartList);
    }
    @Override
    public void isLabel(JLabel lastLabel, Animal animal, int i, JPanel lastPanel, int end, RestartList restartList){
        if(end>=i){
            return;
        }else {
            if(lastLabel!=null){
                System.out.println("传递进来的下标是"+i);
                System.out.println("前面有动物,重新寻找");
                Object[] panelLabel = animal.getPanelLabel(animal, --i);
                isLabel((JLabel)panelLabel[1],animal,i,(JPanel) panelLabel[0],end,restartList);
            }else {
                Object[] objects = new Object[2];
                //保存当前面板
                objects[0] = thisJpanel;
                //保存要交换的面板
                objects[1] = lastPanel;
                //保存步骤
                restartList.push(objects);
                System.out.println("执行交换");
                rightNull(lastPanel);
            }
        }
    }

    @Override
    public void rightNull(JPanel frontPanel){
        animal.isNull(frontPanel,thisJpanel);
    }
}
