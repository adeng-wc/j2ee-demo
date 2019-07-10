package com.adeng.rxjava.demo;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * @author hzwengcheng 2019-06-30 00:27
 */
public class HelloWorld {

    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);

        Observable<String> o = Observable.just("a", "b", "c");

//        def list = [5, 6, 7, 8]
//        Observable<Integer> o = Observable.from(list);
//        Observable<String> o = Observable.just("one object");

    }
}
