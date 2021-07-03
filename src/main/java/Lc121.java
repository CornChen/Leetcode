import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.Arrays;

public class Lc121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
//        for(price in prices){
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}

/**
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < prices.length; i++){
        if(prices[i] > max) max = prices[i];
        if(prices[i] < min){
            max = prices[i];
            min = prices[i];
        }
    }
    return Math.max(0, max - min);
 **/