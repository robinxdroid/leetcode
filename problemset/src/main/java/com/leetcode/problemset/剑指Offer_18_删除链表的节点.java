package com.leetcode.problemset;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/3/21
 */
public class 剑指Offer_18_删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode point = head;
        ListNode prePoint = null;
        while (point != null) {
            if (point.val == val) {
                if (prePoint == null) {
                    // 首元素匹配上，直接改变头节点
                    head = head.next;
                } else {
                    prePoint.next = point.next;
                }
                break;
            }

            prePoint = point;
            point = point.next;
        }

        return head;
    }

    /**
     * 递归实现
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        } else {
            head.next = deleteNode(head.next, val);
        }
        return head;
    }
}
