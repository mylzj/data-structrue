package com.example.datastructure.queue;

/**
 * Demo class
 *基于数组的环状队列
 * @author mylzj
 * @date 2019/7/28 22:46
 */
public class RingQueueByArray {

    private int head=0;
    private int tail=0;
    private int count=0;
    private String item[];

    public RingQueueByArray(int capacity){
        this.item=new String[capacity];
        this.count=capacity;
    }

    //入队列
    public boolean enqueue(String item){
        //队列满的条件是(tail+1)%count==head
        if((tail+1)%count==head){
            return false;
        }
        this.item[tail]=item;
        tail=(tail+1)%count;
        return true;
    }

    //出队列
    public String dequeue(){
        if(head==tail){
            return null;
        }
        String item=this.item[head];
        head=(head+1)%count;
        return item;
    }
}
