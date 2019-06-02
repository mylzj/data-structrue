package com.example.datastructure.statck;

/**
 * Demo class
 *基于数组简单实现一个栈
 * @author drose
 * @date 2019/6/2 21:07
 */
public class ArrayStack {

    private String[] items;//数组
    private int capacity;//容量
    private int currentCount;//当前数量

    public ArrayStack(int capacity){
        this.capacity=capacity;
        this.items=new String[capacity];
        this.currentCount=0;
    }

    //入栈操作
    public boolean push(String str){
        //判断是否超出容量，若超过则返回false
        if(currentCount==capacity){
            return false;
        }
        this.items[currentCount]=str;
        currentCount++;//这里需要讨论下i++和++i的区别
       return true;
    }

    //初栈操作
    public String pop(String str){
        if(currentCount==0){
            return null;
        }
        String tmp=items[currentCount-1];
        currentCount--;
        return tmp;
    }
}
