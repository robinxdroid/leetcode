package com.leetcode.problemset;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 5/28/21
 */
public class 剑指Offer_11_旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        // 既然题目是递增排序，那么初始值最小值肯定是最左边的元素，又因为被旋转过了那么最小值肯定位于右边
        if (numbers.length == 0) {
            return 0;
        }

        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            // 不用(start + end) / 2 是为了防止start和end数字太大溢出
            int mid = start + (end - start) / 2;
            if (numbers[mid] > numbers[end]) {
                // 这种情况middle一定大于最小值，
                // 所以左指针移到middle+1位置没有问题，
                // 搜索空间是[middle+1, end]
                start = mid + 1;
            } else if (numbers[mid] < numbers[end]) {
                // 这种情况middle可能正好是最小值，
                // 所以右指针不能移动到middle-1，需要移动到middle位置,
                // 搜索空间是[start, middle]
                end = mid;
            } else {
                // 比如4 3 4 4 4，middle在中间的4，和start、end都相等
                // 没法判断最小值具体在哪一边
                // 所以end左移一位，
                // 从右向左暴力缩小查找范围
                end--;
            }
        }

        return numbers[start];

    }

}
