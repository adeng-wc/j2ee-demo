import org.junit.Test;

public class UptimeUtilTest {

    @Test
    public void test1() {
        System.out.println(UptimeUtil.getRouterUptime());
        System.out.println(UptimeUtil.getCmdResult("it"));

        String s1 = "14:08:51 up 3 days,  1:04,  2 users,  load average: 0.00, 0.00, 0.00";
        String s5 = "18:09:13 up 1 day,  1:43,  4 users,  load average: 0.51, 0.48, 0.31";
        String s2 = "14:13:34 up  5:06,  4 users,  load average: 0.00, 0.01, 0.05";
        String s3 = "16:41:19 up 8 min,  2 users,  load average: 0.56, 0.39, 0.17";
        String s4 = "18:03:32 up  1:30,  3 users,  load average: 0.06, 0.09, 0.11";

        System.out.println(UptimeUtil.getUptimeSecond(s5));
        System.out.println(UptimeUtil.getUptimeSecond(s1));
    }


}
