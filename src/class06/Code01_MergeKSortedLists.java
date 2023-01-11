package class06;

import java.util.Comparator;
import java.util.PriorityQueue;

// leetcode23：合并k个升序链表
// 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
public class Code01_MergeKSortedLists {

	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static class ListNodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val; 
		}

	}

	// lists的内容是n个链表的头部，每个值后面是一个链表
	// 假设有m个链表，共n个节点
	// 小根堆的大小是m，小根堆的时间复杂度为O(logM),一共要操作n个点，操作为：进去再出来
	// 时间复杂度：O(logM*N)
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}
		PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				heap.add(lists[i]);
			}
		}
		if (heap.isEmpty()) {
			return null;
		}
		ListNode head = heap.poll();
		ListNode pre = head;
		if (pre.next != null) {
			heap.add(pre.next);
		}
		while (!heap.isEmpty()) {
			ListNode cur = heap.poll();
			pre.next = cur;
			pre = cur;
			if (cur.next != null) {
				heap.add(cur.next);
			}
		}
		return head;
	}

}
