public class Lc35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
    }

    public static int  searchInsert(int[] nums, int target) {
//        if(nums.length == 0) return 0;
        int min = 0, max = nums.length - 1, mid = (min + max)/2;
//        while(min < max){
        while(min <= max){
            mid = (min + max)/2;
            if(target == nums[mid]) return mid;
            if(target < nums[mid]) max = mid-1;
            if(target > nums[mid]) min = mid+1;
        }
//        return target < nums[mid] ? mid - 1 : mid + 1;
        return min;
    }
}
