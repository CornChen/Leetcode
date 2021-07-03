public class Lc70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }

    public static int climbStairs(int n) {
//   法1：数组循环
//      遗漏特殊情况判断，导致数组越界
        if(n <= 2) return n;
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        for(int i = 2; i < n; i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[n-1];

//      法2：递归法
//        if(n <= 2) return n;
//        else return climbStairs(n-1) + climbStairs(n-2);
    }
}
