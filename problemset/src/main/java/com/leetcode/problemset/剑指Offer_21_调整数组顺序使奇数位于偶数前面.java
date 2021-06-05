package com.leetcode.problemset;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/5/21
 */
public class 剑指Offer_21_调整数组顺序使奇数位于偶数前面 {

    public int[] exchange(int[] nums) {
        if (nums.length <= 0) {
            return nums;
        }
        int[] result = new int[nums.length];
        int leftIndex = 0;
        int rightIndex = result.length - 1;
        for (int num : nums) {
            // 奇数，从头往尾部放
            if (num % 2 != 0) {
                result[leftIndex] = num;
                leftIndex++;
            } else {
                // 偶数,从尾部往前放
                result[rightIndex] = num;
                rightIndex--;
            }
        }

        return result;
    }

    /**
     * 首尾指针
     *
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        if (nums.length <= 0) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int leftV = nums[left];
            int rightV = nums[right];
            // 奇数
            if (leftV % 2 != 0) {
                left++;
                continue;
            }

            // 偶数
            if (rightV % 2 == 0) {
                right--;
                continue;
            }

            // 交换
            nums[left] = rightV;
            nums[right] = leftV;
        }

        return nums;
    }
}
