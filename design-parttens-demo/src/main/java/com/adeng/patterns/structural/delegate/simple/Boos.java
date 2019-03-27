package com.adeng.patterns.structural.delegate.simple;

/**
 * 老板叫leader完成某个项目
 *
 * @author hzwengcheng 2019-03-27 16:18
 */
public class Boos {

    public static void main(String[] args) {
        Leader leader = new Leader();
        leader.makeProject();
    }
}
