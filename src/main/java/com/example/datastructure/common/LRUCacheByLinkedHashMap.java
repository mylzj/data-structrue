package com.example.datastructure.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/5/22 16:11
 */
public class LRUCacheByLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int cacheCount;

    public LRUCacheByLinkedHashMap(int cacheCount) {
        super(10, 0.75f, true);
        this.cacheCount = cacheCount;
    }

    //LinkedHashMap本身提供这个方法，当超过当前容量就删除最末的数据，需注意，此方法默认放回false
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        //实现这个方法，让它当超过容量时返回true则才会删除末尾的数据
        if (size() > cacheCount) {
            System.out.println("清楚缓存key：" + eldest.getKey());
            return true;
        }
//        return super.removeEldestEntry(eldest);因为默认返回false
        return false;
    }


}
