package com.kitten.Model;

import java.util.LinkedList;

/**
 * @author 27213
 * 对操作进行保存
 */
public class RestartListImpl implements RestartList{
    /**
     * 定义LinkedList，存储操作；
     */
    private LinkedList<Object[]> linkedList = new LinkedList<>();
    @Override
    public void push(Object[] obj){
        linkedList.addFirst(obj);
    }
    @Override
    public Object[] pop(){
        return linkedList.removeFirst();
    }

    @Override
    public void remove() {
        linkedList.clear();
    }
}
