package easy;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

public class Lc136 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }

    /**
     *  异或运算规则： ^_^
     *  一个数和 0 做 XOR 运算等于本身：a⊕0 = a
     *  一个数和其本身做 XOR 运算等于 0：a⊕a = 0
     *  XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
     */
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
