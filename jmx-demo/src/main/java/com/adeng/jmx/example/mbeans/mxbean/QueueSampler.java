package com.adeng.jmx.example.mbeans.mxbean;

import java.util.Date;
import java.util.Queue;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午8:36 2018
 */
public class QueueSampler implements QueueSamplerMXBean {

    private Queue<String> queue;

    public QueueSampler(Queue<String> queue) {
        this.queue = queue;
    }

    public QueueSample getQueueSample() {
        synchronized (queue) {
            return new QueueSample(new Date(), queue.size(), queue.peek());
        }
    }

    public void clearQueue() {
        synchronized (queue) {
            queue.clear();
        }
    }
}
