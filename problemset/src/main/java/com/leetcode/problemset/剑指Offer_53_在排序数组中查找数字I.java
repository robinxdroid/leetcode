package com.leetcode.problemset;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/15/21
 */
public class 剑指Offer_53_在排序数组中查找数字I {

    /**
     * 暴力解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * 二分解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r + 1) / 2;
            if (nums[l] == target) {
                if (nums[r] == target) {
                    return r - l + 1;
                } else if (nums[mid] == target) {
                    r--;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] == target) {
                l++;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }
}
