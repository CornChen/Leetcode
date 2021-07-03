package easy;

public class Lc110 {
    public static void main(String[] args) {
        System.out.println(isBalanced(null));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
//        else if(depth(root.left) - depth(root.right) > 1) return false;
        else if(Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int depth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
