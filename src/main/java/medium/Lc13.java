package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 三数之和
 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
 
 示例 1：
 输入：nums = [-1,0,1,2,-1,-4]
 输出：[[-1,-1,2],[-1,0,1]]

 示例 2：
 输入：nums = []
 输出：[]

 示例 3：
 输入：nums = [0]
 输出：[]
 
 提示：
 0 <= nums.length <= 3000
 -105 <= nums[i] <= 105
 */
public class Lc13 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        if(nums.length < 3) return result;
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        int start = 0, i, j, len = nums.length;
        for(; start < len - 2; start++){
            if(nums[start] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (start > 0 && nums[start] == nums[start - 1]) continue; // 去掉重复情况
            i = start + 1;
            j = len - 1;
            while (i < j){
                if(nums[i] + nums[j] < -nums[start]) i++;
                else if(nums[i] + nums[j] > -nums[start]) j--;
                else{
//                    List<Integer> tmp = new ArrayList<>();
//                    tmp.add(nums[start]);
//                    tmp.add(nums[i]);
//                    tmp.add(nums[j]);
//                    if(!result.contains(tmp)){
//                        result.add(tmp);
//                    } 去重部分优化，在判断重复后直接跳过
                    /** 反复学习!!! **/
                    result.add(new ArrayList<>(Arrays.asList(nums[start], nums[i], nums[j])));
                    // 忘记更新指针位置
                    i++; j--;
                    while (i < j && nums[i] == nums[i - 1]) i++;
                    while (i < j && nums[j] == nums[j + 1]) j--;
                }
            }
        }
        return result;
    }
}
