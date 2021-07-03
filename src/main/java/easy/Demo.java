package easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 26){
            if(columnNumber % 26 != 0){
                sb.append((char)('A' + columnNumber % 26 - 1));
                columnNumber /= 26;
            } else {
                sb.append('Z');
                columnNumber  = columnNumber / 26 - 1;
            }
        }
        sb.append((char)('A' + columnNumber - 1));
        return sb.reverse().toString();
    }

}