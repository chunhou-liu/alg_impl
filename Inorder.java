import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}


public class Inorder {
    /**
        Time Complexity: O(n)
        Space Complexity: O(n)
    */
	public List<Integer> recursiveInorder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		recursiveInorder(root, result);
		return result;
	}
	private void recursiveInorder(TreeNode root, List<Integer> result) {
		if(root==null) return;
		recursiveInorder(root.left, result);
		result.add(root.val);
		recursiveInorder(root.right, result);
	}


    /**
        Time Complexity: O(n)
        Space Complexity: O(n)
    */
	public List<Integer> nonrecursiveInorder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stk = new Stack<>();
		TreeNode p = root;
		while(p!=null || !stk.isEmpty()) {
			if(p!=null) {
				stk.push(p);
				p=p.left;
			} else {
				p=stk.pop();
				result.add(p.val);
				p=p.right;
			}
		}
		return result;
	}

    /**
        Time Complexity: O(n)
        Space Complexity: O(1)
    */
	public List<Integer> morrisInorder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		TreeNode p = root;
		while(p!=null) {
			if(p.left==null) {
				result.add(p.val);
				p=p.right;
			} else {
				TreeNode q=p.left;
				while(q.right!=null && q.right!=p) q=q.right;
				if(q.right==null) {
					q.right=p;
					p=p.left;
				} else {
					q.right=null;
					result.add(p.val);
					p=p.right;
				}
			}
		}
		return result;
	}
}