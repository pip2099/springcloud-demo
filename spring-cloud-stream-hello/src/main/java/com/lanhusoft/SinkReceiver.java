package com.lanhusoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;


/**
 * Copyright@www.lanhusoft.com.
 * Author:lanhusoft
 * Date:2018-08-25
 * Description:
 */

@EnableBinding(value = {Sink.class, SinkSender.class})
public class SinkReceiver {

    Logger logger= LoggerFactory.getLogger(getClass());

//    @StreamListener(Sink.INPUT)
//    public void receive(Object payload){
//        logger.info("====>Receive: "+payload);
//    }

//    @StreamListener(Sink.INPUT)
//    public void receive(Message<String> message){
//        logger.info("====>Receive: "+message.getPayload());
//    }

    @StreamListener(Sink.INPUT)
    public void receive(String message){
        logger.info("====>Receive: "+message);
    }
}
