package com.mockito.demo;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.exceptions.base.MockitoAssertionError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * @author hzwengcheng 2019-03-09 12:56
 */
public class VerifyingTest {

    /**
     * 使用 verify 验证 doSelfCheck 调用过
     */
    @Test
    public void test() {
        WaterSource waterSourceMock = mock(WaterSource.class);
        waterSourceMock.doSelfCheck();
        verify(waterSourceMock).doSelfCheck();
    }

    /**
     * 使用 verify + never 验证 doSelfCheck 没有调用过
     */
    @Test
    public void test1() {
        WaterSource waterSourceMock = mock(WaterSource.class);
        verify(waterSourceMock, never()).doSelfCheck();
    }

    /**
     * 使用 verify + times 验证 getWaterPressure 被调用过 2 次
     */
    @Test
    public void test2() {
        WaterSource waterSourceMock = mock(WaterSource.class);
        waterSourceMock.getWaterPressure();
        waterSourceMock.getWaterPressure();
        verify(waterSourceMock, times(2)).getWaterPressure();
    }

    /**
     * 使用 verify + atLeast 验证 getWaterTemperature 至少被调用过 1 次
     */
    @Test
    public void test3() {
        WaterSource waterSourceMock = mock(WaterSource.class);
        waterSourceMock.getWaterTemperature();
        verify(waterSourceMock, atLeast(1)).getWaterTemperature();
    }


    @Test
    public void shouldVerifyInOrderThroughDifferentMocks() {
        WaterSource waterSource1 = mock(WaterSource.class);
        WaterSource waterSource2 = mock(WaterSource.class);
        waterSource1.doSelfCheck();
        waterSource2.getWaterPressure();
        waterSource1.getWaterTemperature();
        InOrder inOrder = inOrder(waterSource1, waterSource2);
        inOrder.verify(waterSource1).doSelfCheck();
        inOrder.verify(waterSource2).getWaterPressure();
        inOrder.verify(waterSource1).getWaterTemperature();
    }

    @Test
    public void test4() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setColor("yellow");
        searchCriteria.setNumberOfBuds(3);

        FlowerSearcher flowerSearcherMock = mock(FlowerSearcher.class);

        //when
        flowerSearcherMock.findMatching(searchCriteria);
        //then
        ArgumentCaptor<SearchCriteria> captor = ArgumentCaptor.forClass(SearchCriteria.class);
        verify(flowerSearcherMock).findMatching(captor.capture());
        SearchCriteria usedSearchCriteria = captor.getValue();

        assertEquals(usedSearchCriteria.getColor(), "yellow");
        assertEquals(usedSearchCriteria.getNumberOfBuds(), 3);
    }

    @Test
    public void shouldFailForLateCall() {
        WaterSource waterSourceMock = mock(WaterSource.class);
        Thread t = waitAndCallSelfCheck(40, waterSourceMock);
        t.start();
        verify(waterSourceMock, never()).doSelfCheck();
        try {
            verify(waterSourceMock, timeout(20)).doSelfCheck();
            fail("verificationshouldfail");
        } catch (MockitoAssertionError e) {
            //expected
        }
    }

    private Thread waitAndCallSelfCheck(int timeOut, WaterSource waterSourceMock) {
        return new Thread(() -> {
            try {
                Thread.sleep(timeOut);
                waterSourceMock.doSelfCheck();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
