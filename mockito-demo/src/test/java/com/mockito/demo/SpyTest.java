package com.mockito.demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * @author hzwengcheng 2019-03-09 14:41
 */
public class SpyTest {

    @Test
    public void shouldStubMethodAndCallRealNotStubbedMethod() {
        Flower realFlower = new Flower();
        realFlower.setNumberOfLeafs(1);
        Flower flowerSpy = spy(realFlower);

        // flowerSpy 的 setNumberOfLeafs 方法调用的时候什么都不处理
        willDoNothing().given(flowerSpy).setNumberOfLeafs(anyInt());
        flowerSpy.setNumberOfLeafs(2);//stubbed

        verify(flowerSpy).setNumberOfLeafs(2);
        assertEquals(flowerSpy.getNumberOfLeafs(), 1);
    }
}
