public class Lc69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        // int left = 0...      未考虑值溢出
        long left = 0, right = x, mid = 0, square = 0;
        while(left < right){
            mid = (left + right + 1) >> 1;
            square = mid * mid;
            if(x < square) {
                right = mid - 1;
            }else if(x > square) {
                left = mid;
            }else{
                return (int)mid;
            }
        }
        return (int)left;
    }
}
