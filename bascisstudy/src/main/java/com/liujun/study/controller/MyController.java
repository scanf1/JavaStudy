package com.liujun.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "my")
public class MyController {

    @RequestMapping(value = "test")
    public String test()
    {
        return "hello 123 12 12 `1` 12 1221233122   ";

    }
}
