package com.leetcode.problemset;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/6/21
 */
public class 剑指Offer_24_反转链表 {
    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode point = head;
        ListNode prePoint = null;
        while (point != null) {
            // 先取出下一个节点暂存
            ListNode next = point.next;
            // 改变当前节点的下一个节点指向为前一个节点
            point.next = prePoint;

            // 移动两个指针
            // 改变前一个节点指向当前节点
            prePoint = point;
            // 改变当前节点指向为下一个节点
            point = next;
        }
        return prePoint;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
