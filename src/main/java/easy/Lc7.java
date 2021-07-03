package easy;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

public class Lc7 {

    public static void main(String[] args) {
        System.out.println(reverse(121) );
    }

    public static int reverse(int x) {
        int ans = 0, pop = 0;
        while (x != 0) {
            pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
