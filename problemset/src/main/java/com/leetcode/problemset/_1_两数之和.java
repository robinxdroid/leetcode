package com.leetcode.problemset;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author wangbin@huami.com <br>
 * @since 5/19/21
 */
public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int second = nums[j];
                if (first == second) {
                    continue;
                }
                if (first + second == target) {
                    return new int[]{i, j};
                }

            }
        }

        return null;
    }
}
