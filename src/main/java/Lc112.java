import java.util.WeakHashMap;

public class Lc112 {
    public static void main(String[] args) {
        System.out.println(hasPathSum(new TreeNode(1,null,null), 2));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        int sum = targetSum;
        if(root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
