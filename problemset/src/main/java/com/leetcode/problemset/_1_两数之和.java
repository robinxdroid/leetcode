package com.leetcode.problemset;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author wangbin@huami.com <br>
 * @since 5/19/21
 */
public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            throw new IllegalArgumentException("No two sum solution");
        }
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int second = nums[j];
                if (first + second == target) {
                    return new int[]{i, j};
                }

            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
