package easy;

public class Lc53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
    }
    public static int maxSubArray(int[] nums) {
//        int ans = nums[0], sum = nums[0];
        int ans = nums[0], sum = 0;
        for(int num: nums){
            if(sum <= 0){
//                sum = Math.max(sum, num);
                sum = num;
            }else {
//                sum = Math.max(num, sum + num);
                sum += num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
