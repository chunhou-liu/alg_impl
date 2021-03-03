import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Preorder {
    /**
        Time Complexity: O(n)
        Space Complexity: O(n)
    */
    public List<Integer> recursivePreorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursivePreorder(root, result);
        return result;
    }
    private void recursivePreorder(TreeNode root, List<Integer> result) {
        if(root==null) return;
        result.add(root.val);
        recursivePreorder(root.left, result);
        recursivePreorder(root.right, result);
    }

    /**
        Time Complexity: O(n)
        Space Complexity: O(n)
    */
    public List<Integer> nonrecursivePreorder(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> result = new Arraylist<>();
        TreeNode p = root;
        while(p!=null || !stk.isEmpty()) {
            if(p==null) p=stk.pop();
            result.add(p.val);
            if(p.right!=null) stk.push(p.right);
            p=p.left;
        }
        return result;
    }

    /**
        Time Complexity: O(n)
        Space Complexity: O(1)
    */
    public List<Integer> morrisPreorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode p = root;
        while(p!=null) {
            if(p.left==null) {
                result.add(p.val);
                p=p.right;
            } else {
                TreeNode q=p.left;
                while(q.right!=null && q.right!=p) q=q.right;
                if(q.right==p) {
                    q.right=null;
                    p=p.right;
                }
                else {
                    q.right=p;
                    result.add(p.val);
                    p=p.left;
                }
            }
        }
        return result;
    }


}
