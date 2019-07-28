package com.example.datastructure.queue;

/**
 * Demo class
 *基于数组实现队列
 * @author mylzj
 * @date 2019/7/28 21:07
 */
public class QueueByArray {
    //存放元素的数组
    private String item[];
    //长度
    private int count=0;
    //头部元素
    private int head=0;
    //尾部元素
    private int tail=0;

    public QueueByArray(int capacity){
        this.item=new String[capacity];
        this.count=capacity;
    }
    //入队列
    public boolean enqueue(String item){
        if(tail==count){
            if(head==0){
                return false;
            }else {
                //进行数据迁移,有一种情况，就是不断的出队列，
                // 然后当tail指向最末时，实际上头部已经空出来了，
                // 但此时无法入队列。因此要进行数据迁移。考虑时间复杂度。
                for(int i=head;i<tail;i++){
                    this.item[i-head]=this.item[i];
                }
                tail-=head;
                head=0;

            }

        }

        this.item[tail]=item;
        tail++;
        return true;
    }
    //出队列

    public String dequeue(){
        if(head>tail){
            return null;
        }
        String item=this.item[head];
        head++;
        return item;
    }
}
