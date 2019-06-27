package com.lanhusoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Copyright@www.lanhusoft.com.
 * Author:lanhusoft
 * Date:2018-08-21
 * Description:
 */
@RestController
public class ConsumerController {

    //private final Logger logger=Logger.getLogger(getClass());


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/ribbon-consumer")

    public String helloConsumer(){
        return  restTemplate.getForEntity("http://hello-service/say",String.class).getBody();
    }

}
