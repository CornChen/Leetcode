package easy;

import java.util.HashMap;

/** 单词规律
 给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。

 示例1:
 输入: pattern = "abba", str = "dog cat cat dog"
 输出: true

 示例 2:
 输入:pattern = "abba", str = "dog cat cat fish"
 输出: false

 示例 3:
 输入: pattern = "aaaa", str = "dog cat cat dog"
 输出: false

 示例4:
 输入: pattern = "abba", str = "dog dog dog dog"
 输出: false

 说明:
 你可以假设pattern只包含小写字母，str包含了由单个空格分隔的小写字母。
 */
public class Lc290 {
    public boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null ) return false;
        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");
        if(chars.length != strs.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for(int i = 0; i < chars.length; i++){
            if(!map.containsKey(chars[i])) {
                if(map.containsValue(strs[i])) return false;
                else map.put(chars[i], strs[i]);
            }
            else if (!strs[i].equals(map.get(chars[i]))) return false;
        }
        return true;
    }
}
