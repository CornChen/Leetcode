package easy;

public class Lc9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int cur = x, res = 0;
        while(cur != 0){
            if(res == x){
                return true;
            }
            res = res*10 + cur%10;
            cur /= 10;
        }
        return res == x;
    }
}
