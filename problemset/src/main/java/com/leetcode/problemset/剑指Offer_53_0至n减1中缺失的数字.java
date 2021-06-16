package com.leetcode.problemset;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/16/21
 */
public class 剑指Offer_53_0至n减1中缺失的数字 {
    public int missingNumber(int[] nums) {
        // 假设缺失为7
        // value: 0 1 2 3 4 5 6 8 9 10 11  12 13 14 15 16 17 18 19 20
        // index: 0 1 2 3 4 5 6 7 8 9 '10' 11 12 13 14 15 16 17 18 19
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == mid) {
                // 当数值与下标相等，说明缺失的点在右区间
                l = mid + 1;
            } else {
                // 当数值与下标不相等，说明缺失的点在左区间
                r = mid;
            }
        }
        return l;
    }
}
