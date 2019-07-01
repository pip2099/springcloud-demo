package com.lanhusoft;

import com.lanhusoft.Commands.CommandHelloFailure;
import org.junit.Test;
import  static  org.junit.Assert.*;

import java.util.concurrent.Future;

/**
 * Copyright@www.lanhusoft.com.
 * Author:lanhusoft
 * Date:2019-06-30
 * Description:
 */
public class CommandHelloFailureTest {
    @Test
    public void testSynchronous() {
        assertEquals("Hello Failure World!", new CommandHelloFailure("World").execute());
        assertEquals("Hello Failure Bob!", new CommandHelloFailure("Bob").execute());
    }

    @Test
    public void testAsynchronous1() throws Exception {
        assertEquals("Hello Failure World!", new CommandHelloFailure("World").queue().get());
        assertEquals("Hello Failure Bob!", new CommandHelloFailure("Bob").queue().get());
    }

    @Test
    public void testAsynchronous2() throws Exception {

        Future<String> fWorld = new CommandHelloFailure("World").queue();
        Future<String> fBob = new CommandHelloFailure("Bob").queue();

        assertEquals("Hello Failure World!", fWorld.get());
        assertEquals("Hello Failure Bob!", fBob.get());
    }
}
