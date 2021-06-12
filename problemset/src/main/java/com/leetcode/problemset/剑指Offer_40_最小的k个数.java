package com.leetcode.problemset;

import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/12/21
 */
public class 剑指Offer_40_最小的k个数 {
    /**
     * 小顶堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) {
            return arr;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {

        // 快速排序
        quickSort(arr, 0, arr.length);

        int[] res = new int[k];
        if (k >= 0) {
            System.arraycopy(arr, 0, res, 0, k);
        }
        return res;
    }

    /**
     * 快速排序
     * @param arr
     * @param begin
     * @param end
     */
    public void quickSort(int[] arr, int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        // 快速排序
        int pivotIndex = pivotIndex(arr, begin, end);
        // 对子序列进行快速排序
        quickSort(arr, begin, pivotIndex);
        quickSort(arr, pivotIndex + 1, end);
    }

    /**
     * 快速排序轴点构造
     *
     * @param array
     * @param begin
     * @param end
     * @return
     */
    private int pivotIndex(int[] array, int begin, int end) {
        int pivot = array[begin];
        end--;
        while (begin < end) {
            while (begin < end) {
                if (pivot < array[end]) {
                    end--;
                } else {
                    array[begin++] = array[end];
                    break;
                }
            }
            while (begin < end) {
                if (pivot > array[begin]) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        array[begin] = pivot;
        return begin;
    }
}
