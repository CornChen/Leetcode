public class Lc169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,3,1,1,4,1,1,5,1,1,6}));
    }

    /** 多数元素
     *给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 示例1：
     * 输入：[3,2,3]
     * 输出：3
     *
     * 示例2：
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     */
    public static int majorityElement(int[] nums) {
        int candidate = nums[0], count = 0;
        for(int num : nums){
            if(num == candidate) count++;
            else count--;
            if(count < 1) {
                candidate = num;
                // 更换candidate后，忘记初始化count值
                count = 1;
            }
        }
        return candidate;
    }
}
