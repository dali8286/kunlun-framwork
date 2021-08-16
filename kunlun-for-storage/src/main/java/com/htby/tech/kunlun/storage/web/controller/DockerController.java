package com.htby.tech.kunlun.storage.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * docker
 *
 * @author vincent0116
 * @date 2020/01/14
 */
@RequestMapping("/docker")
@RestController
public class DockerController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello-Docker!";
    }

}
