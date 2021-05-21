package com.leetcode.problemset;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
