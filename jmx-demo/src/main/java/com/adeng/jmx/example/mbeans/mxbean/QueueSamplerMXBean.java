package com.adeng.jmx.example.mbeans.mxbean;

/**
 * {@link javax.management.openmbean.CompositeData}
 * @Author: Adengdeng
 * @Date: Create in 下午8:35 2018
 */
public interface QueueSamplerMXBean {

    /* 这里的返回类型被映射成 {@link javax.management.openmbean.CompositeData} */
    public QueueSample getQueueSample();

    public void clearQueue();
}
