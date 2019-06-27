package com.lanhusoft.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Copyright@www.lanhusoft.com.
 * Author:lanhusoft
 * Date:2019-06-26
 * Description:
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    //@Hystrix(fallbackHandler = "helloFallback")
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(){
        return  restTemplate.getForEntity("http://hello-service/say",String.class).getBody();
    }

    public  String helloFallback(){
        return "error";
    }
}
