package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 5/25/21
 */
public class 剑指Offer_07_重建二叉树 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorderRoot = preorderLeft;
        // 在中序遍历中定位根节点
        int intorderRoot = search(inorder, preorder[preorderRoot]);

        TreeNode rootNode = new TreeNode(preorder[preorderRoot]);

        // 得到左子树中的节点数目
        int sizeLeftSubtree = intorderRoot - inorderLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 sizeLeftSubtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        rootNode.left = buildTree(preorder, inorder,
                preorderRoot + 1,
                preorderRoot + sizeLeftSubtree,
                inorderLeft,
                intorderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素

        rootNode.right = buildTree(preorder, inorder,
                preorderRoot + 1 + sizeLeftSubtree,
                preorderRight,
                intorderRoot + 1,
                inorderRight);
        return rootNode;

    }

    HashMap<Integer, Integer> map = new HashMap<>();

    int search(int[] array, int v) {
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], i);
            }
        }
        return map.get(v);
    }
}
