package com.adeng.codewar.train.decompose;

import java.util.ArrayList;

/**
 * Created by w11282 on 2018/3/6.
 */
public class Decompose {

    /**
     * 给一个正整数，返回一个严格递增的序列的数字，平方和等于n^2
     * 如果有多个，返回结果有最大值的。
     * <p>
     * 解决思路：
     * 定义一个List，记录递增数字
     * 给定一个50，计算出 50 * 50 = 2500
     * 从49开始遍历，判断 49 * 49 < 2500，2500 - 49 * 49 = 99，将49插入到List中
     * 定义一个子List1，记录当前阶段的递增数字
     * 从9开始遍历，因为 10 * 10 > 99, 执行 99 - 9 * 9 = 18，将9插入到List1
     * 定义一个子List2，记录当前阶段的递增数字
     * 从4开始遍历，因为 5 * 5 > 18, 执行 18 - 4 * 4 = 3，将4插入到List2
     * 从1开始遍历，因为 2 * 2 > 3,执行 3 - 1*1 = 2，计算结果不为0，所以当前循环失败，跳转到上一层，从更低一位数自计算
     * 从3开始计算  ...... 一直到1，失败也跳转
     * 从8开始计算，.....一直到1，失败也跳转
     * 从48开始遍历，
     *
     * @param n
     * @return
     */
    public String decompose(long n) {

        ArrayList<Long> list = new ArrayList<>();
        /**
         * 假如是11，那就从10开始遍历，如果最后不能整除，就从48开始
         */
        for (long i = n - 1; i > 0; i--) {
            list.clear();
            list.add(i);
            long sum = n * n - i * i;
            ArrayList<Long> iList = getSubList(i - 1, sum);

            if (iList.size() > 0) {
                list.addAll(iList);

                StringBuffer sb = new StringBuffer();

                list.stream().sorted().forEach(arr -> sb.append(arr + " "));

                return sb.toString().trim();
            }
        }

        return null;
    }

    /**
     *
     * @param i 遍历的最大数  10
     * @param iSum 减少之后的总数 21
     * @return
     */
    private ArrayList<Long> getSubList(long i, long iSum) {
        ArrayList<Long> iList = new ArrayList<>();

        //iSum = 21, cur = 4....
        double cur = Math.sqrt(iSum);
        //start = 4
        long start = (long) cur;

        //避免出现 3 3 9 49 这种情况
        if (i < start) {
            iList.clear();
            return iList;
        }

        //cur不是整数
        if (cur != start) {
            ArrayList<Long> jList = new ArrayList<>();
            for (long j = start; j > 0; j--) {
                //如果从4开始计算失败，那就清空集合，从3开始计算
                jList.clear();

                jList.add(j);
                //21 - 16 = 5
                long jSum = iSum - j * j;

                if (jSum <= 0 ) {
                    iList.addAll(jList);
                    return iList;
                }

                if (iSum == 2 && j == 1) {
                    iList.clear();
                    return iList;
                }

                ArrayList<Long> subList = getSubList(j - 1, jSum);
                if (subList.size() > 0) {
                    jList.addAll(subList);
                    return jList;
                }
            }
        } else {
            iList.add(start);
        }
        return iList;
    }
}
