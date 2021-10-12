package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 字母异位词分组
 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。

 示例 1:
 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

 示例 2:
 输入: strs = [""]
 输出: [[""]]

 示例 3:
 输入: strs = ["a"]
 输出: [["a"]]

 提示：
 1 <= strs.length <= 104
 0 <= strs[i].length <= 100
 strs[i]仅包含小写字母
 */
public class Lc49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            int len = str.length();
            for(int i = 0; i < len; i++){
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                if(count[i] != 0){
//                    sb.append(str.charAt(i));
                    sb.append('a' + i);
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}


