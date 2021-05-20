package com.leetcode.problemset;

import java.util.Arrays;

public class Launcher {
    public static void main(String[] args) {

        print(new _1_两数之和().twoSum(new int[]{2, 7, 11, 15}, 9));


        ListNode node1 = new ListNode(5, null);
        ListNode node2 = new ListNode(5, null);
        print(new _2_两数相加().addTwoNumbers(node1, node2));
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
        }
    }
}