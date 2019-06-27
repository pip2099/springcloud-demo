package com.lanhusoft.controller;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Copyright@www.lanhusoft.com.
 * Author:lanhusoft
 * Date:2018-08-20
 * Description:
 */
@RestController
public class HelloController {

    //private final Logger logger=Logger.getLogger(getClass());

//    @Autowired
//    private DiscoveryClient client;

    @RequestMapping(value="/say")
    public String say(){
        return  "Hi";
    }
}
