package com.example.datastructure.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author mylzj
 * @Date 2020/12/14 23:28
 */
public class BoxQueue {
    BlockingQueue<String> box = new ArrayBlockingQueue<>(3);

    public void product(){
        try {
            box.put("an apple");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String consume(){
        String take = null;
        try {
            take = box.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return take;
    }

    public int getSize(){
        return box.size();
    }

    public static void main(String[] args){
        test();
    }
    public static void test(){
        final BoxQueue box1 = new BoxQueue();

        class BoxProduct implements Runnable{

            @Override
            public void run() {
                while (true){
                    System.out.println("开始往盒子放苹果");
                    System.out.println("盒子的苹果数量："+box1.getSize());
                    box1.product();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        class BoxConsume implements Runnable{

            @Override
            public void run() {
                while (true){
                    System.out.println("开始往盒子取苹果");
                    box1.consume();
                    System.out.println("盒子的苹果数量："+box1.getSize());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        BoxProduct boxProduct = new BoxProduct();
        BoxConsume boxConsume = new BoxConsume();
        executorService.submit(boxProduct);
        executorService.submit(boxConsume);
        executorService.shutdown();
    }
}
