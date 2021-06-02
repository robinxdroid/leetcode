package com.leetcode.problemset;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/2/21
 */
public class 剑指Offer_17_打印从1到最大的n位数 {

    public int[] printNumbers(int n) {
        StringBuilder numBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            numBuilder.append("9");
        }
        int num = Integer.parseInt(numBuilder.toString());
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i + 1;
        }

        return result;

    }
}
