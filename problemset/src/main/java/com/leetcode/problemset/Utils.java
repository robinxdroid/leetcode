package com.leetcode.problemset;

/**
 * @author wangbin@huami.com <br>
 * @since 6/6/21
 */
public class Utils {
    public static ListNode arrayToListNode(int... values) {
        ListNode head = new ListNode(values[0]);
        ListNode point = head;
        for (int i = 1; i < values.length; i++) {
            point.next = new ListNode(values[i]);
            point = point.next;
        }
        return head;
    }
}
