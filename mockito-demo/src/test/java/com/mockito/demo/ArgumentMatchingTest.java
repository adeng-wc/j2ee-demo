package com.mockito.demo;

import org.junit.Test;
import org.mockito.ArgumentMatcher;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * @author hzwengcheng 2019-03-08 21:39
 */
public class ArgumentMatchingTest {

    Date WANTED_DATE = new Date();
    int VALUE_FOR_WANTED_ARGUMENT = 0;
    Date ANY_OTHER_DATE = new Date();

    @Test
    public void shouldMatchSimpleArgument() {
        WateringScheduler schedulerMock = mock(WateringScheduler.class);
        given(schedulerMock.getNumberOfPlantsScheduledOnDate(WANTED_DATE)).willReturn(VALUE_FOR_WANTED_ARGUMENT);

        int numberForWantedArgument = schedulerMock.getNumberOfPlantsScheduledOnDate(WANTED_DATE);
        assertEquals(numberForWantedArgument, VALUE_FOR_WANTED_ARGUMENT);

        int numberForAnyOtherArgument = schedulerMock.getNumberOfPlantsScheduledOnDate(ANY_OTHER_DATE);
        assertEquals(numberForAnyOtherArgument, 0);  //default value for int
    }

    @Test
    public void givenTest() {
        WateringScheduler plantSearcherMock = mock(WateringScheduler.class);
        given(plantSearcherMock.smellyMethod(anyInt(), contains("asparag"), eq("red"))).willReturn(true);

        assertEquals(plantSearcherMock.smellyMethod(1, "asparag", "red"), true);
        assertEquals(plantSearcherMock.smellyMethod(1, "1", "red"), false);
        assertEquals(plantSearcherMock.smellyMethod(1, "asparag", "red1"), false);
        assertEquals(plantSearcherMock.smellyMethod(null, "asparag", "red1"), false);
    }

    //with the util method to create a matcher
    private ArgumentMatcher<Date> haveHourFieldEqualTo(final int hour) {
        return new ArgumentMatcher() {
            @Override
            public boolean matches(Object argument) {
                return ((Date) argument).getHours() == hour;
            }
        };
    }

    @Test
    public void givenTest2() {
        WateringScheduler schedulerMock = mock(WateringScheduler.class);
        given(schedulerMock.getNumberOfPlantsScheduledOnDate(argThat(haveHourFieldEqualTo(7)))).willReturn(1);
        Date date =  new Date();
        date.setHours(7);
        assertEquals(schedulerMock.getNumberOfPlantsScheduledOnDate(new Date()), 0);
        assertEquals(schedulerMock.getNumberOfPlantsScheduledOnDate(date), 1);
    }

    @Test
    public void shouldReturnLastDefinedValueConsistently() {
        WaterSource waterSource = mock(WaterSource.class);
        given(waterSource.getWaterPressure()).willReturn(3, 5);
        assertEquals(waterSource.getWaterPressure(), 3);
        assertEquals(waterSource.getWaterPressure(), 5);
        assertEquals(waterSource.getWaterPressure(), 5);
    }

}
