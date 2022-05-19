package com.kitten.Model;

/**
 * @author 27213
 */
public interface RestartList {

    /**
     * 提供存储操作方法
     * @param obj
     */
    public void push(Object[] obj);

    /**
     * 提供弹出上一次操作的方法
     */
    public Object[] pop();
    /**
     *
     * 清空集合
     */
    public void remove();
}
