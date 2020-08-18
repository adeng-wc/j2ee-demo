import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class UptimeUtil {

    /**
     * 获取linux命令执行的结果,cat 之类
     *
     * @param cmd
     * @return
     */
    public static String getCmdResult(String cmd) {
        String result = "";
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line;
            while ((line = input.readLine()) != null) {
                result = line;
            }
        } catch (java.io.IOException e) {
            System.err.println("IOException " + e.getMessage());
        }
        return result;
    }

    /**
     * 返回运行时间的秒
     *
     * @return
     */
    public static String getUptimeSecond(String str) {
        String time = null;
        if (str.contains(",")) {
            String[] strArr = str.split(",");
            if (strArr.length > 2) {
                int hms = 0;
                int days = 0;
                if (str.contains("days")) {
                    //截取到天
                    String day = strArr[0].substring(strArr[0].indexOf("up") + 2, strArr[0].indexOf("days")).trim();
                    //天的秒数
                    days = Integer.parseInt(day) * 24 * 3600;
                    //时分秒的秒数
                    hms = Integer.parseInt(getHms(strArr[1].replace("min", "").trim()));
                } else if (str.contains("day")) {
                    //截取到天
                    String day = strArr[0].substring(strArr[0].indexOf("up") + 2, strArr[0].indexOf("day")).trim();
                    //天的秒数
                    days = Integer.parseInt(day) * 24 * 3600;
                    //时分秒的秒数
                    hms = Integer.parseInt(getHms(strArr[1].replace("min", "").trim()));
                } else {
                    String hmsStr = strArr[0].substring(strArr[0].indexOf("up") + 2);
                    hms = Integer.parseInt(getHms(hmsStr.replace("min", "").trim()));
                }
                Integer totalTime = days + hms;
                time = totalTime.toString();
            }
        }
        return time;
    }

    /**
     * 获取中间字段的秒数
     *
     * @param str
     * @return
     */
    public static String getHms(String str) {
        String result = null;
        Integer hms = 0;
        if (str.contains(":")) {
            String[] hmsArr = str.split("\\:");
            int length = hmsArr.length;
            switch (length) {
                //只有秒
                case 1:
                    hms += Integer.parseInt(hmsArr[0]);
                    break;
                //时分
                case 2:
                    hms += (Integer.parseInt(hmsArr[0]) * 3600 + Integer.parseInt(hmsArr[1]) * 60);
                    break;
                //时分秒
                case 3:
                    hms += (Integer.parseInt(hmsArr[0]) * 3600 + Integer.parseInt(hmsArr[1]) * 60 + Integer.parseInt(hmsArr[2]));
                    break;
            }
        } else {
            //不包含： 只能是分
            hms += Integer.parseInt(str) * 60;
        }
        if (hms > 0) {
            result = hms.toString();
        }
        return result;
    }

    /**
     * 获取运行时间
     *
     * @return
     */
    public static String getRouterUptime() {
        return getUptimeSecond(getCmdResult("uptime"));
    }
}
