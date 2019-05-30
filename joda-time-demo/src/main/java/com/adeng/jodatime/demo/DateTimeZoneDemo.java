package com.adeng.jodatime.demo;

import org.joda.time.DateTimeZone;
import org.junit.Test;

/**
 * @author hzwengcheng 2019-05-30 19:19
 */
public class DateTimeZoneDemo {

    @Test
    public void test(){
        DateTimeZone zone = DateTimeZone.forID("Europe/London");
        System.out.println(zone);
        System.out.println(zone.toTimeZone());
        System.out.println(zone.toTimeZone().getDisplayName());
        System.out.println(zone.toTimeZone().useDaylightTime());
    }

    @Test
    public void test1(){
        DateTimeZone zoneUTC = DateTimeZone.UTC;

    }

    @Test
    public void test2(){
        DateTimeZone zoneUTC = DateTimeZone.forOffsetHours(24);


    }

    @Test
    public void test3(){
        DateTimeZone defaultZone = DateTimeZone.getDefault();


    }

}
