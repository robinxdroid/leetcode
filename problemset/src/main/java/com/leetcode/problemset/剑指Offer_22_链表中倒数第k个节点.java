package com.leetcode.problemset;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/6/21
 */
public class 剑指Offer_22_链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode point = head;
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int count = 0;
        while (point != null) {
            nodeMap.put(count, point);
            point = point.next;
            count++;
        }
        return nodeMap.get(nodeMap.size() - k);
    }

    /**
     * 快慢指针
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        ListNode low = head;
        int n = 0;
        while (fast != null) {
            fast = fast.next;
            if (n >= k) {
                low = low.next;
            }
            n++;
        }
        return low;
    }
}
