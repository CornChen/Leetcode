package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 **/
public class Lc145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        sufTree(root, list);
        return list;
    }

    public void sufTree(TreeNode root, List<Integer> list){
        if(root != null) {
            sufTree(root.left, list);
            sufTree(root.right, list);
            list.add(root.val);
        }
    }
}
