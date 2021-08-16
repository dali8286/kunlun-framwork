package com.htby.tech.kunlun.storage.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * index
 *
 * @author vincent0116
 * @date 2020/01/14
 */
@Slf4j
@RestController
public class IndexController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "This is index";
    }
}
