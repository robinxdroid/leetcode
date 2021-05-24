package com.leetcode.problemset;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 5/24/21
 */
public class 剑指Offer_05_替换空格 {
    public String replaceSpace(String s) {
        String regex = " ";
        if (!s.contains(regex)) {
            return s;
        }
        return s.replace(regex, "%20");
    }

    /**
     * 不使用replace api
     *
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        char regex = ' ';
        char[] array = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == regex) {
                result.append('%');
                result.append('2');
                result.append('0');
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * 不使用replace api
     *
     * @param s
     * @return
     */
    public String replaceSpace3(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }
}
