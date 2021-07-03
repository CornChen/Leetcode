import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lc20 {
    public static void main(String[] args) {
        System.out.println(isValid("(([{}]{([{}])})"));
    }

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        map.put('?', '!');
        Stack<Character> stack = new Stack<>();
        stack.push('?');
        for(char c : s.toCharArray()) {
            /**
             if(map.containsValue(c)) return false;
             else stack.push(c);
             if(map.get(stack.lastElement()) == c) stack.pop();
             */
            if( map.containsKey(c)) stack.push(c);
            else if( c != map.get( stack.pop())) return false;
        }
        return stack.size() == 1;
    }
}
