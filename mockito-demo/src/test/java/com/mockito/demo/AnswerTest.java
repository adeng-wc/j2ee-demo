package com.mockito.demo;

import org.junit.Test;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;

/**
 * @author hzwengcheng 2019-03-09 12:45
 */
public class AnswerTest {

    private static final int TEST_NUMBER_OF_FLOWERS = 1;

    @Test
    public void shouldReturnTheSameValue() {
        FlowerFilter filterMock = mock(FlowerFilter.class);
        given(filterMock.filterNoOfFlowers(anyInt())).will(returnFirstArgument());
        int filteredNoOfFlowers = filterMock.filterNoOfFlowers(TEST_NUMBER_OF_FLOWERS);
        assertEquals(filteredNoOfFlowers, TEST_NUMBER_OF_FLOWERS);
    }

    //reusable answer class
    public class ReturnFirstArgument implements Answer<Object> {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            Object[] arguments = invocation.getArguments();
            if (arguments.length == 0) {
                throw new MockitoException("...");
            }
            return arguments[0];
        }
    }

    private ReturnFirstArgument returnFirstArgument() {
        return new ReturnFirstArgument();
    }
}
