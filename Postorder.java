import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}


public class Postorder {
	public List<Integer> recursivePostorder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		recursivePostorder(root, result);
		return result;
	}
	private void recursivePostorder(TreeNode root, List<Integer> result) {
		if(root==null) return;
		recursivePostorder(root.left, result);
		recursivePostorder(root.right, result);
		result.add(root.val);
	}

	public List<Integer> nonrecursivePostorder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stk = new Stack<>();
		TreeNode p=root, q=null;
		while(p!=null || !stk.isEmpty()) {
			if(p!=null) {
				stk.push(p);
				p=p.left;
			} else {
				p=stk.pop();
				if(p.right==null || q==p.right) {
					result.add(p.val);
					q=p;
					p=null;
				} else {
					stk.push(p);
					p=p.right;
				}
			}
		}
		return result;
	}

	public List<Integer> morrisPostorder(TreeNode root) {
		// 后序遍历为LRN, 其反序遍历为NRL，因此先进行NRL前序遍历，然后再求反即可
		List<Integer> result = new ArrayList<>();
		TreeNode p = root;
		while(p!=null) {
			if(p.right==null) {
				result.add(p.val);
				p=p.left;
			} else {
				TreeNode q=p.right;
				while(q.left!=null && q.left!=p) q=q.left;
				if(q.left==null) {
					q.left=p;
					result.add(p.val);
					p=p.right;
				} else {
					q.left=null;
					p=p.left;
				}
			}
		}
		Collections.reverse(result);
		return result;
	}
}