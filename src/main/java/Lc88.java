public class Lc88 {
    public static void main(String[] args) {
        merge(new int[]{1,1,2,3,5,0,0,0}, 5, new int[]{2,4,5}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0){
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
//        学习一个
//        System.arraycopy(nums1, 0, nums2, 0, len2+1);
//        System.arraycopy(nums2, 0, nums1, 0, len2);
        System.arraycopy(nums2, 0, nums1, 0, len2+1);
    }
}
