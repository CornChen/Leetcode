package medium;

import java.util.ArrayList;
import java.util.List;

/** 括号生成
 数字 n,代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 示例 1：
 输入：n = 3
 输出：["((()))","(()())","(())()","()(())","()()()"]
 示例 2：
 输入：n = 1
 输出：["()"]

 提示：
 1 <= n <= 8
 https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
 */
public class Lc22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public static void backtrack(List<String> res, StringBuilder sb, int open, int close, int max){
        if(sb.length() == max * 2){
            res.add(sb.toString());
            return;
        }
        if(open < max){
            sb.append('(');
            backtrack(res, sb, open+1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(')');
            backtrack(res, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
