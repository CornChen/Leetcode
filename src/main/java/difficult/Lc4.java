package difficult;

import java.util.ArrayList;
import java.util.List;

/** 寻找两个正序数组的中位数
 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 示例 1：
 输入：nums1 = [1,3], nums2 = [2]
 输出：2.00000
 解释：合并数组 = [1,2,3] ，中位数 2

 示例 2：
 输入：nums1 = [1,2], nums2 = [3,4]
 输出：2.50000
 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

 示例 3：
 输入：nums1 = [0,0], nums2 = [0,0]
 输出：0.00000

 示例 4：
 输入：nums1 = [], nums2 = [1]
 输出：1.00000

 示例 5：
 输入：nums1 = [2], nums2 = []
 输出：2.00000

 提示：
 nums1.length == m
 nums2.length == n
 0 <= m <= 1000
 0 <= n <= 1000
 1 <= m + n <= 2000
 -106 <= nums1[i], nums2[i] <= 106
 */
public class Lc4 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0;
        if(nums2.length > nums1.length) return findMedianSortedArrays(nums2, nums1);
        int i = 0, j = 0;
        List<Integer> nums = new ArrayList<>();

        while (i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]) nums.add(nums1[i++]);
            else nums.add(nums2[j++]);
        }if(i < nums1.length){
            for(;i < nums1.length; i++) nums.add(nums1[i]);
        }else for(;j < nums2.length; j++) nums.add(nums2[j]);

        int len = nums.size();
        return len % 2 == 0 ? (nums.get(len/2 - 1) + nums.get(len/2)) / (double)2 : (double)nums.get(len / 2);
    }
}
