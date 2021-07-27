package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 四数之和
 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 注意：答案中不可以包含重复的四元组。
 
 示例 1：
 输入：nums = [1,0,-1,0,-2,2], target = 0
 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

 示例 2：
 输入：nums = [], target = 0
 输出：[]
 
 提示：
 0 <= nums.length <= 200
 -10^9 <= nums[i] <= 10^9
 -10^9 <= target <= 10^9
 */
public class Lc18 {
    public static void main(String[] args) {
        System.out.println(fourSum2(new int[]{-2,-1,-1,1,1,2,2}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        int len = nums.length;
        if(nums[0] + nums[1] + nums[2] + nums[3] > target || nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4] < target) return res;
        int left = 0, right = len - 1;
        while (left < right){
            int i = left + 1, j = right - 1;
            if(nums[i] + nums[i + 1] > target - nums[left] - nums[right]) {
                right--;
                continue;
            }else if(nums[j] + nums[j - 1] < target - nums[left] - nums[right]){
                left++;
                continue;
            }
            while (i < j){
                if(nums[i] + nums[j] < target - nums[left] - nums[right]) {
                    i++;
//                    while (i < len - 1 && nums[i] == nums[i - 1]) i++;
                }
                else if(nums[i] + nums[j] > target - nums[left] - nums[right]) {
                    j--;
//                    while(j > 0 && nums[j] == nums[j + 1]) j--;
                }else {
                    res.add(new ArrayList<>(Arrays.asList(nums[left], nums[i], nums[j], nums[right])));
                    // 忘记更新指针位置
                    i++;
                    while (i < len - 1 && nums[i] == nums[i - 1]) i++;
                    j--;
                    while(j > 0 && nums[j] == nums[j + 1]) j--;
                }
            }
            // 忘记更新指针位置
            left++;
            // 忘记去重
            while (left < len - 1 && nums[left] == nums[left - 1]) left++;
            right--;
            while (right > 0 && nums[right] == nums[right + 1]) right--;
        }
        return res;
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        int len = nums.length;
        for(int k = 0; k < len - 3; k++){
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            if(nums[k] + nums[k+1] + nums[k+2] + nums[k+3] > target) break;
            if(nums[k] + nums[len-1] + nums[len-2] + nums[len - 3] < target) continue;
            // 嵌套循环从k+1开始，不会漏判
            for(int i = k+1; i < len - 2; i++){
//                if(i > k+1 && nums[k] == nums[k+1]) continue;
                if(i > k+1 && nums[i] == nums[i-1]) continue;
                int j = i+1, h = len - 1;
                int min = nums[k] + nums[i] + nums[j] + nums[j+1];
                if(min > target) break;
                int max = nums[k] + nums[i] + nums[h-1] + nums[h];
                if(max < target) continue;
                while(j < h){
                    int cur = nums[k] + nums[i] + nums[j] + nums[h];
                    if(cur == target){
                        res.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j-1]) j++;
                        h--;
                        while (j < h && nums[h] == nums[h+1]) h--;
                    }else if(cur < target){
                        j++;
                    }else {
                        h--;
                    }
                }
            }
        }
        return res;
    }
}
