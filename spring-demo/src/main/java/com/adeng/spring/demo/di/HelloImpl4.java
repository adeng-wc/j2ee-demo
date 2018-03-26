package com.adeng.spring.demo.di;

import com.adeng.spring.demo.HelloApi;
import lombok.Data;

/**
 * setter方法注入
 *
 * @author
 * @create 2018-03-25 下午2:05
 */
@Data
public class HelloImpl4 implements HelloApi {

    private String message;

    private int index;

    @Override
    public void sayHello() {
        System.out.println(index + ":" + message);
    }
}
