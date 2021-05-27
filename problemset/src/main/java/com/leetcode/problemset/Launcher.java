package com.leetcode.problemset;

import com.leetcode.problemset.printer.BinaryTrees;

import java.util.Arrays;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {

        print(new _1_两数之和().twoSum(new int[]{2, 7, 11, 15}, 9));


        ListNode node1 = new ListNode(5, null);
        ListNode node2 = new ListNode(5, null);
        print(new _2_两数相加().addTwoNumbers(node1, node2));

        print(new _3_无重复字符的最长子串().lengthOfLongestSubstring("aab"));

        print(new _4_寻找两个正序数组的中位数().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));

        print(new _5_最长回文子串().longestPalindrome("abba"));

        print(new 剑指Offer_05_替换空格().replaceSpace2("We are happy."));

        print(new 剑指Offer_07_重建二叉树().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));

        剑指Offer_09_用两个栈实现队列.CQueue cQueue = new 剑指Offer_09_用两个栈实现队列.CQueue();
        cQueue.appendTail(20);
        cQueue.appendTail(30);
        cQueue.appendTail(40);
        cQueue.appendTail(50);
        cQueue.appendTail(60);
        print(cQueue.deleteHead());
        print(cQueue.deleteHead());
        print(cQueue.deleteHead());
        print(cQueue.deleteHead());
        print(cQueue.deleteHead());
    }

    private static <T> void print(T t) {

        if (t instanceof int[]) {
            System.out.println(Arrays.toString((int[]) t));
        } else if (t instanceof ListNode) {
            ListNode node = (ListNode) t;
            while (node != null) {
                System.out.print(node.val + " --> ");
                node = node.next;
            }
            System.out.println("");
        } else if (t instanceof char[]) {
            char[] charArray = (char[]) t;
            for (char c : charArray) {
                System.out.print(c + " ");
            }
            System.out.println("");
        } else if (t instanceof List) {
            List list = (List) t;
            for (Object o : list) {
                System.out.print(o + " ");
            }
            System.out.println("");
        } else if (t instanceof TreeNode) {
            BinaryTrees.println(new TreeNodeWrapper((TreeNode) t));
        } else {
            System.out.println(t);
        }
    }
}