package com.leetcode.problemset;

/**
 * @author wangbin@huami.com <br>
 * @since 6/6/21
 */
public class Utils {
    /**
     * 链表化
     * @param values
     * @return
     */
    public static ListNode arrayToListNode(int... values) {
        ListNode head = new ListNode(values[0]);
        ListNode point = head;
        for (int i = 1; i < values.length; i++) {
            point.next = new ListNode(values[i]);
            point = point.next;
        }
        return head;
    }

    /**
     * 树化
     * @param values
     * @return
     */
    public static TreeNode treefy(int... values){
        TreeNode root = null;
        for (int v : values) {
            // 添加第一个节点
            if (root == null) {
                root = new TreeNode(v);
                continue;
            }

            // 添加的不是第一个节点
            TreeNode parent = root;
            TreeNode node = root;
            int cmp = 0;
            do {
                cmp = v - node.val;
                parent = node;
                if (cmp > 0) {
                    node = node.right;
                } else if (cmp < 0) {
                    node = node.left;
                } else { // 相等
                    node.val = v;
                    break;
                }
            } while (node != null);

            // 看看插入到父节点的哪个位置
            TreeNode newNode = new TreeNode(v);
            if (cmp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
        }
        return root;
    }

}
