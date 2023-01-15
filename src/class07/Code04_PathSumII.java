package class07;

import java.util.ArrayList;
import java.util.List;

// 收集达标路径和
public class Code04_PathSumII {

	// 测试链接：https://leetcode.com/problems/path-sum-ii
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		ArrayList<Integer> path = new ArrayList<>();
		process(root, path, 0, sum, ans);
		return ans;
	}

	// 参数的含义：当前节点、该路径上已经处理过的节点、当前路径的累加和、预期的累加和、符合累加和的路径集合
	public static void process(TreeNode x, List<Integer> path, int preSum, int sum, List<List<Integer>> ans) {
		if (x.left == null && x.right == null) { // 如果是叶子节点判断累加和是否符合预期
			if (preSum + x.val == sum) {
				path.add(x.val); // 添加当前节点到当前路径中
				ans.add(copy(path));
				path.remove(path.size() - 1); // 恢复现场，因为前面path添加了当前节点；但尝试别的路径的时候要把当前节点去掉
			}
			return;
		}
		// x 非叶节点
		path.add(x.val);
		preSum += x.val;
		if (x.left != null) {
			process(x.left, path, preSum, sum, ans);
		}
		if (x.right != null) {
			process(x.right, path, preSum, sum, ans);
		}
		path.remove(path.size() - 1); // 恢复现场
	}

	public static List<Integer> copy(List<Integer> path) {
		List<Integer> ans = new ArrayList<>();
		for (Integer num : path) {
			ans.add(num);
		}
		return ans;
	}

}
