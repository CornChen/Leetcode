package medium;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/** 无重复字符的最长子串
 *
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
