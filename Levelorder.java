import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}


class Levelorder {
	public List<Integer> levelorder(TreeNode root) {
		if(root==null) return new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode p = queue.poll();
			result.add(p.val);
			if(p.left!=null) queue.add(p.left);
			if(p.right!=null) queue.add(p.right);
		}
		return result;
	}
}