package medium;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/** 盛最多水的容器
 *给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 
 * 提示：
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 */ 
public class Lc11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    // 双指针
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j){
            max = Math.max(max, Math.min(height[j], height[i]) * (j - i));
            if(height[i] < height[j]) i++;
            else j--;
        }
        return max;
    }

    // time out
    public static int maxArea2(int[] height) {
        int max = 0, tmp = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
//                tmp = Math.min(i, j);
//                max = max < tmp * (j - i) ? tmp : max;
                tmp = Math.min(height[i], height[j]);
                max = max < tmp * (j - i) ? tmp * (j - i) : max;
            }
        }
        return max;
    }
}
