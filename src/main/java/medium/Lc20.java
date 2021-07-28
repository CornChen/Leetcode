package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/** 有效的括号
 给定一个只包括 '('，')'，'{'，'}'，'['，']',的字符串 s ，判断字符串是否有效。
 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。

 示例,2：
 输入：s = "()[]{}"
 输出：true

 示例,3：
 输入：s = "(]"
 输出：false

 示例,4：
 输入：s = "([)]"
 输出：false

 示例,5：
 输入：s = "{[]}"
 输出：true
 提示：
 1 <= s.length <= 104
 s 仅由括号 '()[]{}' 组成
 https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
 */
public class Lc20 {
    public static void main(String[] args) {
        System.out.println(isValid(")("));
    }

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
//        防止stack.peek为空
        stack.push('#');
        for(char c : s.toCharArray()){
            if(map.containsValue(c)) stack.push(c);
//            else if(map.containsValue(c) && stack.peek() == c) stack.pop();
//          忘记考虑stack为空时stack.peek()的问题
            else if(map.containsKey(c) && stack.peek() == map.get(c)) stack.pop();
            else return false;
        }
//        防止stack.peek为空
        stack.pop();
        return stack.isEmpty();
    }
}
