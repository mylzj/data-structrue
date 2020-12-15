package com.example.datastructure.queue;

/**
 * @Description
 * @Author mylzj
 * @Date 2020/12/16 0:06
 */
public class RingQueueByArrayV2 {
    private Object[] items;
    private int head = 0;
    private int tail = 0;
    private int total = 0;

    public RingQueueByArrayV2(int count) throws Exception {
        if (count < 0) {
            throw new Exception("队列长度不能小于0");
        }
        items = new Object[count];
        total = count;
    }

    public boolean push(Object object) {
        // 队列满了
        if ((tail + 1) % total == head) {
            return false;
        }
        items[tail] = object;
        tail = (tail + 1) % total;
        return true;
    }

    public Object pop() {
        if (tail == head) {
            return null;
        }
        Object item = items[head];
        head = (head + 1) % total;
        return item;
    }
}
