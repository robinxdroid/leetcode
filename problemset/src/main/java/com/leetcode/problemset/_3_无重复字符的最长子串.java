package com.leetcode.problemset;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 5/21/21
 */
public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        List<Character> childChain = new ArrayList<>();
        List<Character> maxChildChain = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            childChain.clear();
            childChain.add(c);

            for (int j = i + 1; j < charArray.length; j++) {
                char c2 = charArray[j];

                if (childChain.contains(c2)) {
                    break;
                } else {
                    // 子串追加char
                    childChain.add(c2);
                }
            }

            // 与之前记录子串比较选取最大子串
            if (childChain.size() > maxChildChain.size()) {
                maxChildChain.clear();
                maxChildChain.addAll(childChain);
            }
        }

        return maxChildChain.size();
    }
}
