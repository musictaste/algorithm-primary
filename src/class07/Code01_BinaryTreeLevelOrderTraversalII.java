package class07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// leetcode0102二叉树按层遍历并收集节点
// 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii
public class Code01_BinaryTreeLevelOrderTraversalII {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// 步骤1：得到树的深度size
	// 步骤2：遍历每一层，利用队列，头结点先进去，如果这层没有其他节点，开始弹出节点，并把该节点的左右子节点放到队列中
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<>();
		if (root == null) {
			return ans;
		}
		Queue<TreeNode> queue = new LinkedList<>(); // Queue是接口，不能new Queue()
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size(); // 必须把每层的节点数记录下来，因为队列是动态变化的
			List<Integer> curAns = new LinkedList<>(); // 每一层的节点链表；使用linkedList的原因：因为是从头部逆序的结果
			for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				curAns.add(curNode.val);
				if (curNode.left != null) {
					queue.add(curNode.left);
				}
				if (curNode.right != null) {
					queue.add(curNode.right);
				}
			}
			ans.add(0, curAns); // 因为要倒序输出，所以把每一层都放到链表的头部，从而实现逆序
		}
		return ans;
	}

}
