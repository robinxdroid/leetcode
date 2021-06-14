package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/14/21
 */
public class 剑指Offer_52_两个链表的第一个公共节点 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode aPoint = headA;
        ListNode bPoint = headB;
        // 遍历完链表A和链表B后两个结点都为null，是相等的，则返回null，跳出循环
        while (aPoint != bPoint) {
            aPoint = aPoint == null ? headB : aPoint.next;
            bPoint = bPoint == null ? headA : bPoint.next;
        }

        return aPoint;
    }
}
