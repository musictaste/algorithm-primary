package class06;

// 判断两颗树是否结构相同
// 测试链接：https://leetcode.com/problems/same-tree
public class Code02_SameTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null ^ q == null) { // 一个为空，一个不为空，异或结果为true
			return false;
		}
		if (p == null && q == null) {
			return true;
		}
		// 都不为空
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
