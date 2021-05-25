package com.leetcode.problemset;

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
        /*int rootIndex = 0;
        int rootValue = preorder[rootIndex];
        TreeNode rootNode = new TreeNode(rootValue);
        TreeNode point = rootNode;

        int next = preorder[rootIndex + 1];

        int index = binarySearch(inorder, rootValue);
        int inorderPreValue = inorder[index - 1];

        if (inorderPreValue == next) {
            point.left = new TreeNode(inorderPreValue);
            point.right =
        }

        return*/

        return null;

    }

    int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + end / 2;
            if (target == array[mid]) {
                return mid;
            }

            if (target > mid) {
                start = mid + 1;
            } else if (target < mid) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
