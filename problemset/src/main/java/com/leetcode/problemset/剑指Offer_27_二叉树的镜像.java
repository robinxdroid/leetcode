package com.leetcode.problemset;

import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/7/21
 */
public class 剑指Offer_27_二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            mirror(root, root.left, root.right);
        }
        return root;
    }

    private void mirror(TreeNode root, TreeNode left, TreeNode right) {
        if (left != null) {
            mirror(left, left.left, left.right);
        }

        if (right != null) {
            mirror(right, right.left, right.right);
        }

        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

    }

    /**
     * 官方题解，更简化，但是内存消耗比上方的递归高一些
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    /**
     * 非递归解法
     * @param root
     * @return
     */
    public TreeNode mirrorTree3(final TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>() {{
            add(root);
        }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
