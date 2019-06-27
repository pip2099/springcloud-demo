package com.lanhusoft;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

import javax.sound.midi.MetaMessage;

/**
 * Copyright@www.lanhusoft.com.
 * Author:lanhusoft
 * Date:2018-08-25
 * Description:
 */
public interface SinkSender {

    @Output(Source.OUTPUT)
    MessageChannel output();
}
