package com.adeng.leetcode.array;

import java.util.stream.IntStream;

class Solution {
    public int removeDuplicates(int[] nums) {

        nums = IntStream.of(nums).distinct().toArray();

        return nums.length;
    }
}
