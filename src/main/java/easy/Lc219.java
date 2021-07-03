package easy;

import java.util.HashSet;

public class Lc219 {
    public static void main(String[] args) {
        System.out.println();
    }

    /** 存在重复元素 II
     *给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
     * 示例1:
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     *
     * 示例 2:
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     *
     * 示例 3:
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(hashSet.contains(nums[i])) return true;
            hashSet.add(nums[i]);
//            if(i - k >= 3) hashSet.remove(i-k);
            if(hashSet.size() > k) hashSet.remove(nums[i-k]);
        }
        return false;
    }
}
