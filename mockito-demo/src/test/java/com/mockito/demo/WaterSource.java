package com.mockito.demo;

import lombok.Data;

/**
 * @author hzwengcheng 2019-03-08 22:02
 */
@Data
public class WaterSource {

    String testStr;

    public int getWaterPressure() {
        return 0;
    }

    public void doSelfCheck() {
        System.out.printf("doSelfCheck");
    }

    public void getWaterTemperature() {
        System.out.printf("getWaterTemperature");
    }
}
