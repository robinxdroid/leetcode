package com.leetcode.problemset;

import com.leetcode.problemset.printer.BinaryTreeInfo;

/**
 * @author wangbin@huami.com <br>
 * @since 5/26/21
 */
public class TreeNodeWrapper implements BinaryTreeInfo {
    private TreeNode node;

    public TreeNodeWrapper(TreeNode node) {
        this.node = node;
    }

    /**
     * who is the root node
     */
    @Override
    public Object root() {
        return node;
    }

    /**
     * how to get the left child of the node
     *
     * @param node
     */
    @Override
    public Object left(Object node) {
        return ((TreeNode)node).left;
    }

    /**
     * how to get the right child of the node
     *
     * @param node
     */
    @Override
    public Object right(Object node) {
        return ((TreeNode)node).right;
    }

    /**
     * how to print the node
     *
     * @param node
     */
    @Override
    public Object string(Object node) {
        TreeNode myNode = (TreeNode)node;
        return myNode.val;
    }
}
