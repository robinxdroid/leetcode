package com.leetcode.problemset;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/8/21
 */
public class 剑指Offer_29_顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length <= 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int[] res = new int[(r + 1) * (b + 1)];
        int resIndex = 0;
        while (true) {
            // 从左往右
            for (int i = l; i <= r; i++) {
                res[resIndex++] = matrix[t][i];
            }

            if (++t > b) {
                break;
            }
            // 从上往下
            for (int i = t; i <= b; i++) {
                res[resIndex++] = matrix[i][r];
            }

            if (--r < l) {
                break;
            }
            // 从右往左
            for (int i = r; i >= l; i--) {
                res[resIndex++] = matrix[b][i];
            }

            if (--b < t) {
                break;
            }
            // 从下往上
            for (int i = b; i >= t; i--) {
                res[resIndex++] = matrix[i][l];
            }

            if (++l > r) {
                break;
            }
        }

        return res;
    }
}
