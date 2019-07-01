package com.lanhusoft;

import com.lanhusoft.Commands.CommandThatFailsFast;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Copyright@www.lanhusoft.com.
 * Author:lanhusoft
 * Date:2019-06-30
 * Description:
 */
public class CommandThatFailsFastTest {
    @Test
    public void testSuccess() {
        assertEquals("success", new CommandThatFailsFast(false).execute());
    }

    @Test
    public void testFailure() {
        try {
            new CommandThatFailsFast(true).execute();
            fail("we should have thrown an exception");
        } catch (HystrixRuntimeException e) {
            assertEquals("failure from CommandThatFailsFast", e.getCause().getMessage());
            e.printStackTrace();
        }
    }
}
