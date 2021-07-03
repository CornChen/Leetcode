package easy;

public class Lc122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        int sum = 0;
        for(int i = 0; i < len - 1; i++){
            if(prices[i+1] - prices[i] > 0) sum += prices[i+1] - prices[i];
        }
        return sum;
    }
}
