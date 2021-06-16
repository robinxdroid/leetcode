package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/16/21
 */
public class 剑指Offer_54_二叉搜索树的第k大节点 {

    /**
     * 大顶堆解法，比较耗时间
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        PriorityQueue<TreeNode> nodes = new PriorityQueue<>((treeNode, t1) -> t1.val - treeNode.val);
        traversal(root, nodes);

        int res = -1;
        for (int i = 0; i < k; i++) {
            TreeNode node = nodes.poll();
            if (node != null) {
                res = node.val;
            }
        }
        return res;
    }

    private void traversal(TreeNode root, PriorityQueue<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        traversal(root.left, nodes);
        traversal(root.right, nodes);
    }


    int k;

    /**
     * 反向中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        postOrder(root);
        return v;
    }

    int v = 0;
    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.right);
        if (k > 0) {
            v = root.val;
            k--;
        }
        if (k > 0) {
            postOrder(root.left);
        }
    }
}
