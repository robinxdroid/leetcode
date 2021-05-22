package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 5/22/21
 */
public class _4_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> numList = new ArrayList<>(nums1.length + nums2.length);
        for (int value : nums1) {
            numList.add(value);
        }
        for (int value : nums2) {
            numList.add(value);
        }
        Collections.sort(numList);

        int remainder = numList.size()%2;
        if (remainder != 0) {
            return numList.get(numList.size() / 2);
        } else {
            int midIndex = numList.size() / 2;
            int preIndex = midIndex-1;
            return ((double)numList.get(midIndex)+(double)numList.get(preIndex))/2;
        }
    }
}
