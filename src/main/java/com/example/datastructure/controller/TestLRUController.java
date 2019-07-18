package com.example.datastructure.controller;

import com.example.datastructure.LinkedList.LRUByLinkedHashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/5/23 10:31
 */
@Controller
@RequestMapping("/LRU")
public class TestLRUController {
    private LRUByLinkedHashMap lru = new LRUByLinkedHashMap(5);

    @ResponseBody
    @GetMapping("/add/{value}")
    public String getAll(@PathVariable String value) {
        this.lru.add(value);
        this.lru.getAll();
        return "200";
    }
}
