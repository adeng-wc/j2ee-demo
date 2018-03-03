package com.adeng.codewar.train.solution;

/**
 * @Author: Adengdeng
 * @Date: Create in 下午7:55 2018
 */
public class Solution {

    /*
  如果我们列出所有低于10的自然数是3或5的倍数，我们得到3,5,6和9，这些倍数的总和为23。

  完成解决方案，以便返回低于传入数字的所有3或5的倍数的总和。

  注意：如果数字是3和5的倍数，则只计算一次。
  */
    public int solution(int number) {

        //总和
        int sum = 0;

        for (int i = 1; isContinue(i, number); i++) {

            if ((3 * i) % 15 != 0) {
                if ((3 * i) < number) {
                    sum += 3 * i;
                }
            }

            if ((5 * i) < number) {
                sum += 5 * i;
            }
        }

        return sum;
    }

    //判断循环是否继续
    public boolean isContinue(int i, int number) {

        if (((3 * i) >= number) && ((5 * i) >= number)) {
            return false;
        }
        return true;
    }
}

