package com.lanhusoft.Commands;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

/**
 * Copyright@www.lanhusoft.com.
 * Author:lanhusoft
 * Date:2019-06-30
 * Description:
 */
public class CommandThatFailsFast2 extends HystrixObservableCommand<String> {

    private final boolean throwException;

    public CommandThatFailsFast2(boolean throwException) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.throwException = throwException;
    }


    @Override
    protected Observable<String> construct() {
        if (throwException) {
            throw new RuntimeException("failure from CommandThatFailsFast");
        } else {
            return Observable.just("success");
        }
    }

    @Override
    protected Observable<String> resumeWithFallback() {
        if (throwException) {
            return Observable.error(new Throwable("failure from CommandThatFailsFast"));
        } else {
            return Observable.just("success");
        }
    }
}
