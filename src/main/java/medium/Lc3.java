package medium;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/** 无重复字符的最长子串
 *给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * 
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 * 
 * 提示：
 * 0 <= s.length <= 5 * 10^4
 * s由英文字母、数字、符号和空格组成
 */
public class Lc3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        tmmzuxt dvdf
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        int left = 0, right = 0, count = 1, max = 1;
//        还是需要map来记录重复字符
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(; right < chars.length; right++){
            if(!map.containsKey(chars[right]) || map.get(chars[right]) < left) {
                map.put(chars[right], right);
                max = Math.max(right - left + 1, max);
            }
            else{
                left = map.get(chars[right]) + 1;
//                不能忘记重新初始化map.get(key)， 也不能直接remove
                map.put(chars[right], right);
            }
        }
        return max;
    }
}
