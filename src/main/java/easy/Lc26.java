package easy;

public class Lc26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,2,3,4,5,6,7,8,9,10,10,10,10}));
    }
    public static int removeDuplicates(int[] nums) {
        int p = 0, q = 0;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                nums[++p] = nums[q];
            }
            q++;
        }
        return p+1;
    }
}
