package com.leetcode.problemset;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/10/21
 */
public class 剑指Offer_39_数组中出现次数超过一半的数字 {

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        // 设x = 众数，votes = 票数
        int x = 0, votes = 0;
        for (int num : nums) {
            // 票为0，假设num为众数
            if (votes == 0) {
                x = num;
            }
            // 当前数字与众数相等，票数+1，否则票数-1
            int vote = num == x ? 1 : -1;
            votes += vote;
        }

        return x;
    }
}
