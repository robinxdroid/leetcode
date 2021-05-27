package com.leetcode.problemset;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 5/25/21
 */
public class 剑指Offer_09_用两个栈实现队列 {
    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    static class CQueue {
        Stack<Integer> inStack = new Stack<Integer>();
        Stack<Integer> outStack = new Stack<Integer>();

        public CQueue() {

        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        public int deleteHead() {
            if (inStack.isEmpty() && outStack.isEmpty()) {
                return -1;
            }

            if (outStack.isEmpty()) {
                int length = inStack.size();
                for (int i = 0; i < length; i++) {
                    outStack.push(inStack.pop());
                }

            }
            return outStack.pop();
        }

    }
}
