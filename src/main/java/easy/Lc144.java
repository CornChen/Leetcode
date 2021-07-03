package easy;

import java.util.ArrayList;
import java.util.List;


public class Lc144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preTree(root,list);
        return list;
    }

    public void preTree(TreeNode root, List<Integer> list){
        if(root != null) {
            list.add(root.val);
            preTree(root.left,list);
            preTree(root.right,list);
        }
    }
}
