package difficult;

import java.util.Map;
import java.util.Stack;

/**  最长有效括号
给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。

示例 1：
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"

示例 2：
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"

示例 3：
输入：s = ""
输出：0

提示：
0 <= s.length <= 3 * 104
s[i] 为 '(' 或 ')'
 */
public class Lc32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses2("()(()"));
    }

    public static int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 0;
        char[] cs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static int longestValidParentheses2(String s) {
        int left = 0, right = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') left++;
            else right++;
            if(right > left) {
                left = right = 0;
//            }else if(right == left) max = 2 * right;
            }else if(right == left) max = Math.max(max, 2 * left);
        }
        left = 0;
        right = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ')') right++;
            else left++;
            if(left > right) {
                left = right = 0;
//            }else if(right == left) max = 2 * right;
            }else if(right == left) max = Math.max(max, 2 * left);
        }
        return max;
    }
}
