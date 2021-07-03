package easy;

public class Lc108 {
    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8}));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
        }

    public static TreeNode dfs(int[] nums, int low, int high) {
//    校验有问题，应以入参中low和high进行判断
//        if(nums.length == 0) return null;
        if(low > high) return null;
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, low, mid - 1);
//        root.right = dfs(nums, mid, high);
        root.right = dfs(nums, mid + 1, high);
        return root;
    }
}


