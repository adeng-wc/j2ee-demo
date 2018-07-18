package com.adeng.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * @author hzwengcheng 2018-06-13 17:24
 */
public class FastJsonTest {

    public static void main(String[] args) {

        A a = A.builder().build();

        System.out.println(JSONObject.toJSON(a));
    }

}
