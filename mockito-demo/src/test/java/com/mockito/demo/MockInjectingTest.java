package com.mockito.demo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.assertNotNull;

/**
 * @author hzwengcheng 2019-03-09 14:55
 */
public class MockInjectingTest {

    @Mock
    private WaterSource waterSourceMock;
    @Spy
    private WateringScheduler wateringSchedulerSpy;
    @InjectMocks
    private PlantWaterer plantWaterer;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldInjectMocks() {
        assertNotNull(plantWaterer.getWaterSource());
        assertNotNull(plantWaterer.getWateringScheduler());
    }

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private PlantWaterer plantWatererMock;

    @Test
    public void test2() {
        assertNotNull(plantWatererMock.getWaterSource());
    }
}
