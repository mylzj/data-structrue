package com.example.datastructure;

import com.example.datastructure.LinkedList.LRUByLinkedHashMap;
import com.example.datastructure.common.LRUCacheByLinkedHashMap;
import com.example.datastructure.statck.ArrayStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataStructureApplicationTests {

    @Test
    public void contextLoads() {

        testArrayStack();
    }

    public void testArrayStack() {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push("1");
        arrayStack.push("2");
        boolean push = arrayStack.push("3");
//        boolean push = arrayStack.push("4");
        if (push) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
