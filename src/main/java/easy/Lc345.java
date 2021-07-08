package easy;

import java.util.HashSet;
import java.util.Set;

/** 反转字符串中的元音字母
 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

 示例 1：
 输入："hello"
 输出："holle"

 示例 2：
 输入："leetcode"
 输出："leotcede"
 */
public class Lc345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('i');
        set.add('o');
        set.add('e');
        set.add('u');
        // 忘记区分大小写
        set.add('A');
        set.add('I');
        set.add('O');
        set.add('E');
        set.add('U');
        while (i < j){
            while (i < s.length() && !set.contains(chars[i])) i++;
            while (j > 0 && !set.contains(chars[j])) j--;
            if(i < j && set.contains(chars[i]) && set.contains(chars[j])){
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
        return String.copyValueOf(chars);
    }
}
