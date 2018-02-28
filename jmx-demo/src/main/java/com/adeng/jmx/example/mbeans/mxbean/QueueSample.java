package com.adeng.jmx.example.mbeans.mxbean;

import java.beans.ConstructorProperties;
import java.util.Date;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午8:37 2018
 */
public class QueueSample {

    private final Date date;
    private final int size;
    private final String head;

    @ConstructorProperties({"date", "size", "head"})
    public QueueSample(Date date, int size, String head) {
        this.date = date;
        this.size = size;
        this.head = head;
    }

    public Date getDate() {
        return date;
    }

    public int getSize() {
        return size;
    }

    public String getHead() {
        return head;
    }
}
