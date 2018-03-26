package com.adeng.codewar.train.iprange;

/**
 * 判断IP是否在某个网段范围内
 */
public class IpRangeTest {


    static class IpRange {

        String start;

        String end;

        public IpRange(String start, String end) {
            this.start = start;
            this.end = end;
        }

        public boolean contain(String ip) {

            String[] startArr = start.split(".");
            String[] endArr = end.split(".");
            String[] ipArr = ip.split(".");


            for (int i = 0; i < ipArr.length; i++) {

                if (containInt(startArr[i], ipArr[i], endArr[i])) {

                    continue;
                } else {
                    return false;
                }
            }

            return true;
        }

        /**
         * 判断中间的数字是否在中间
         *
         * @param startIp
         * @param ip
         * @param endIp
         * @return
         */
        private boolean containInt(String startIp, String ip, String endIp) {

            //和首IP相等
            if ((Integer.valueOf(startIp) ^ Integer.valueOf(ip)) == 0 ) {
                return true;
            }

            //和尾IP相等
            if ((Integer.valueOf(endIp) ^ Integer.valueOf(ip)) == 0 ) {
                return true;
            }

            //起始IP的长度
            int startLrn = Integer.toBinaryString(Integer.valueOf(startIp)).length();




            return false;
        }

    }

    /*
        123.256.10.1-123.256.18.25
        123.456.789.1-123.471.123.12
     */
    public static void main(String[] args) {

        IpRange ipRange = new IpRange("123.256.10.1", "123.256.18.25");

        String testIp = "123.256.10.11";

 /*       System.out.println( Integer.toBinaryString(Integer.valueOf("10")));
        System.out.println( Integer.toBinaryString(Integer.valueOf("11")));

        System.out.println( Integer.toBinaryString(Integer.valueOf("13")));

        System.out.println(Integer.toBinaryString(10 & 11));
        System.out.println(Integer.toBinaryString(10 & 9));*/
//        System.out.println(ipRange.contain(testIp));

//        System.out.println(Integer.toBinaryString( 123 << 24 | 254 <<16 | 10 << 8 | 1));

        int start = 123 << 24 | 254 <<16 | 10 << 8 | 1;
        int end = 123 << 24 | 254 << 16 | 18 << 8 | 66;

        int ip = 123 << 24 | 254 << 16 | 17 << 8 | 36;

        System.out.println(Integer.toBinaryString(start));
        System.out.println(Integer.toBinaryString(end));

        System.out.println(Integer.toBinaryString(ip));
        System.out.println("-------------");
        System.out.println(Integer.toBinaryString(start & ip));
        System.out.println(Integer.toBinaryString(end & ip));



        if ((start & ip) >= start &&  end >= (end & ip)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }

}
