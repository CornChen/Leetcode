package easy;

import java.util.HashMap;

public class Lc242 {

    /** 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */

    public static void main(String[] args) {
        System.out.println(isAnagram("rat","tar"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
           char key = s.charAt(i);
           if(!s_map.containsKey(key)){
               s_map.put(key,1);
           }else s_map.put(key, s_map.get(key) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            char key = t.charAt(i);
            if(!t_map.containsKey(key)){
                t_map.put(key,1);
            }else t_map.put(key, t_map.get(key) + 1);
        }
        return s_map.equals(t_map);
    }

    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            char key = t.charAt(i);
            map.put(key, map.getOrDefault(key, 0) - 1);
            if(map.get(key) < 0) return false;
        }
        return true;
    }
}
