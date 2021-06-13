package com.leetcode.problemset;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangbin@huami.com <br>
 * @since 6/13/21
 */
public class 剑指Offer_50_第一个只出现一次的字符 {
    public char firstUniqChar(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int v = map.get(c);
                map.put(c, v + 1);
            } else {
                map.put(c, 1);
            }
        }
        char res = ' ';
        if (map.containsValue(1)) {
            for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
                if (characterIntegerEntry.getValue() == 1) {
                    res = characterIntegerEntry.getKey();
                    break;
                }
            }
        }
        return res;
    }
}
