package com.mockito.demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * @author hzwengcheng 2019-03-08 21:12
 */
public class SubbingTest {

    public static final int TEST_NUMBER_OF_LEAFS = 5;

    @Test
    public void subbingTest() {
        Flower flowerMock = mock(Flower.class);
        when(flowerMock.getNumberOfLeafs()).thenReturn(TEST_NUMBER_OF_LEAFS);
        int numberOfLeafs = flowerMock.getNumberOfLeafs();
        assertEquals(numberOfLeafs, TEST_NUMBER_OF_LEAFS);
    }

    @Test
    public void shouldReturnGivenValueUsingBDDSemantics() {
        //given
        Flower flowerMock = mock(Flower.class);
        given(flowerMock.getNumberOfLeafs()).willReturn(TEST_NUMBER_OF_LEAFS);
        //when
        int numberOfLeafs = flowerMock.getNumberOfLeafs();
        //then
        assertEquals(numberOfLeafs, TEST_NUMBER_OF_LEAFS);
    }

    @Test(expected = WaterException.class)
    public void shouldStubVoidMethod() {
        WaterSource waterSourceMock = mock(WaterSource.class);
        doThrow(WaterException.class).when(waterSourceMock).doSelfCheck();
        //the same with BDD semantics
        //willThrow(WaterException.class).given(waterSourceMock).doSelfCheck();

        waterSourceMock.doSelfCheck();
        //exception expected
    }
}
