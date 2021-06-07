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

        print(new 剑指Offer_03_数组中重复的数字().findRepeatNumber(new int[]{1, 2, 3, 4, 2, 5, 6, 3}));

        print(new 剑指Offer_11_旋转数组的最小数字().minArray(new int[]{3, 4, 5, 6, 1, 2}));
        print(new 剑指Offer_11_旋转数组的最小数字().minArray(new int[]{2, 2, 2, 0, 1}));

        char[][] chars = new char[][]{{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        String word = "ABCCED";
        print(new 剑指Offer_12_矩阵中的路径().exist(chars, word));

        print(new 剑指Offer_15_二进制中1的个数().hammingWeight(9));

        print(new 剑指Offer_17_打印从1到最大的n位数().printNumbers(3));

        print(new 剑指Offer_18_删除链表的节点().deleteNode(Utils.arrayToListNode(5, 3, 7, 8), 8));

        print(new 剑指Offer_21_调整数组顺序使奇数位于偶数前面().exchange2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));

        print(new 剑指Offer_22_链表中倒数第k个节点().getKthFromEnd2(Utils.arrayToListNode(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3));

        print(new 剑指Offer_24_反转链表().reverseList(Utils.arrayToListNode(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        print(new 剑指Offer_25_合并两个排序的链表().mergeTwoLists(Utils.arrayToListNode(1, 2, 6, 7, 8, 10), Utils.arrayToListNode(3, 4, 8, 9, 11)));

        print(Utils.treefy(1,4,5,10,2,7,6,3,8));
        print(new 剑指Offer_27_二叉树的镜像().mirrorTree(Utils.treefy(1,4,5,10,2,7,6,3,8)));
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
            System.out.println("null");
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