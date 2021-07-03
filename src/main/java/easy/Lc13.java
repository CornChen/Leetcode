package easy;

import java.util.HashMap;
import java.util.Map;

public class Lc13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        if(s.equals("")){
            return 0;
        } else if(s.length() == 1){
            return map.get(s);
        }
        int ans = 0;
        for (int i=0; i < s.length() - 1; i++){
            int s0 = map.get(s.substring(i,i+1));
            int s1 = map.get(s.substring(i+1,i+2));
            if( s0 < s1 ){
                ans -= s0;

            } else {
                ans += s0;
            }

        }
        return ans + map.get(s.substring(s.length() - 1));

    }

    /**最优解  99.93/98.73
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
     */

}
