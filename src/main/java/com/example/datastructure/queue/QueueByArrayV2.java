package com.example.datastructure.queue;

/**
 * @Description
 * @Author mylzj
 * @Date 2020/12/15 23:45
 */
public class QueueByArrayV2 {
    private Object[] items;
    private int head = 0;
    private int tail = 0;
    private int total = 0;

    public QueueByArrayV2(int count) throws Exception {
        if (count < 0) {
            throw new Exception("队列长度不能小于0");
        }
        items = new Object[count];
        total = count;
    }

    // 入队列
    public boolean push(Object object) {

        if (tail == total) {
            if(head == 0){
                return false;
            }
            for (int i = 0; i < tail - head; i++) {
                items[i] = items[head + i];
            }
        }

        tail = tail - head;
        head = 0;

        items[tail] = object;
        ++tail;
        return true;
    }

    // 出队列
    public Object pop() {
        if (tail == head) {
            return null;
        }
        Object item = items[head];
        ++head;
        return item;
    }
}
