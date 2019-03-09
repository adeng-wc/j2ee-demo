package com.mockito.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * @author hzwengcheng 2019-03-08 20:47
 */
@RunWith(value = MockitoJUnitRunner.class)
public class MockTest {

//    @Before
//    public void initMocks() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Mock
    private List<Integer> integers;

    @Test
    public void mockTest(){

        // mock creation
        List mockedList = mock(List.class);

        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        integers.add(1);
        integers.clear();
    }
}
