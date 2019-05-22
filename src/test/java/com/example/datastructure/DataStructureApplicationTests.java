package com.example.datastructure;

import com.example.datastructure.common.LRUCacheByLinkedHashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataStructureApplicationTests {

    @Test
    public void contextLoads() {

        LRUCacheByLinkedHashMap lru=new LRUCacheByLinkedHashMap(3);
        lru.put("1",1);
        lru.put("2",2);
        lru.put("3",3);
        lru.put("4",4);
        lru.put("2",2);
        System.out.println(lru.toString());
    }

}
