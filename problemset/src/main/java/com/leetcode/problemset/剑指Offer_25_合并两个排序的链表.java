package com.leetcode.problemset;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/7/21
 */
public class 剑指Offer_25_合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟一个头节点
        ListNode head = new ListNode(-1);
        ListNode headPoint = head;
        // 有一个为空直接跳出循环
        while (l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;
            if (v1 < v2) {
                headPoint.next = l1;
                l1 = l1.next;
            } else if (v1 > v2) {
                headPoint.next = l2;
                l2 = l2.next;
            } else {
                // 相等，取p1或者p2都可以
                headPoint.next = l1;
                l1 = l1.next;
            }
            headPoint = headPoint.next;
        }

        // 处理循环完还剩余节点的链表
        headPoint.next = l1 != null ? l1 : l2;
        // 因为是虚拟的头节点，所以返回虚拟头节点的next
        return head.next;
    }
}
