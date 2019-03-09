package com.mockito.demo;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * @author hzwengcheng 2019-03-09 15:49
 */
public class MockDefaultTest {

    @Test
    public void test() {
        PlantWaterer mock = mock(PlantWaterer.class, Mockito.RETURNS_DEEP_STUBS);
        given(mock.getWaterSource().getWaterPressure()).willReturn(5);
        assertEquals(mock.getWaterSource().getWaterPressure(), 5);
    }


}
