public class Lc27 {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1,5,6,6,6,6,6,6,7,8}, 6));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0, ans = nums.length - 1;
        while(i < ans){
            if(nums[i] == val){
                nums[i] = nums[ans--];
            }else{
                i++;
            }
        }
        return ans;
    }
}
