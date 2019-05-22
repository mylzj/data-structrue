package com.example.datastructure;

import com.example.datastructure.LinkedList.LRUByLinkedHashMap;
import com.example.datastructure.common.LRUCacheByLinkedHashMap;
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
        LRUByLinkedHashMap lru=new LRUByLinkedHashMap(5);
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(5);
        lru.add(6);
        lru.getAll();
    }

}
