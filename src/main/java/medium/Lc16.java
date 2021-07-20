package medium;

import java.util.Arrays;

/** 最接近的三数之和
 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 
 示例：
 输入：nums = [-1,2,1,-4], target = 1
 输出：2
 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 
 提示：
 3 <= nums.length <= 10^3
 -10^3<= nums[i]<= 10^3
 -10^4<= target<= 10^4
 */
public class Lc16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4,-5}, 1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, result = target, len = nums.length;
        if(nums[0] + nums[1] + nums[2] >= target) return nums[0] + nums[1] + nums[2];
        if(nums[len - 1] + nums[len - 2] + nums[len - 3] <= target) return nums[len - 1] + nums[len - 2] + nums[len - 3];
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1, right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) return sum;
                else if(sum < target) {
                    if(target - sum < diff){
                        diff = target - sum;
                        result = sum;
                    }
                    left++;
//                    while(left < right && nums[left] == nums[--left]) left++;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                }else {
                    if(sum - target < diff){
                        diff = sum - target;
                        result = sum;
                    }
                    right--;
//                    while (left < right && nums[right] == nums[++right]) right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return result;
    }
}
