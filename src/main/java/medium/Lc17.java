package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 电话号码的字母组合
 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 
 示例 1：
 输入：digits = "23"
 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

 示例 2：
 输入：digits = ""
 输出：[]

 示例 3：
 输入：digits = "2"
 输出：["a","b","c"]
 
 提示：
 0 <= digits.length <= 4
 digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Lc17 {

    char[] digit = {'2','3','4','5','6','7','8','9'};
    char[][] c = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] chars = digits.toCharArray();
    }
}
