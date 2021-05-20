package com.leetcode.problemset;

import java.math.BigInteger;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author wangbin@huami.com <br>
 * @since 5/19/21
 */
public class _2_两数相加 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 是否需要进位
        boolean needCarry = false;
        // 根节点
        ListNode root = null;
        // 节点指针
        ListNode point = null;
        while (l1 != null || l2 != null) {
            int value1 = l1 == null ? -1 : l1.val;
            int value2 = l2 == null ? -1 : l2.val;

            int resultValue = 0;
            if (value1 < 0 && value2 >= 0) {
                resultValue = value2;
            }

            if (value2 < 0 && value1 >= 0) {
                resultValue = value1;
            }

            if (value1 >= 0 && value2 >= 0) {
                resultValue = value1 + value2;
            }

            // 需要进位
            if (needCarry) {
                resultValue++;
                needCarry = false;
            }
            // 需要记录进位
            if (resultValue >= 10) {
                resultValue = resultValue % 10;
                // 记录进位
                needCarry = true;
            }

            if (root == null) {
                root = new ListNode(resultValue);
                point = root;
            } else {
                point.next = new ListNode(resultValue);
                point = point.next;
            }

            // 需要进位
            if (needCarry){
                point.next = new ListNode(1);
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return root;
    }

}
