package class04;

// 两个链表相加
// 测试链接：https://leetcode.com/problems/add-two-numbers/
public class Code05_AddTwoNumbers {

	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		int len1 = listLength(head1);
		int len2 = listLength(head2);
		ListNode l = len1 >= len2 ? head1 : head2;
		ListNode s = l == head1 ? head2 : head1;
		ListNode curL = l;
		ListNode curS = s;
		ListNode last = curL; // 用于长短链表都没有的时候，又有进位信息的时候补节点时，找到长链表的最后一个节点
		int carry = 0; // 进位信息
		int curNum = 0;
		// 长、短链表都有
		while (curS != null) {
			curNum = curL.val + curS.val + carry;
			curL.val = (curNum % 10);
			carry = curNum / 10;
			last = curL;
			curL = curL.next;
			curS = curS.next;
		}
		// 长链表有、短链表没有
		while (curL != null) {
			curNum = curL.val + carry;
			curL.val = (curNum % 10);
			carry = curNum / 10;
			last = curL;
			curL = curL.next;
		}
		// 长短链表都没有
		if (carry != 0) {
			last.next = new ListNode(1);
		}
		return l;
	}

	// 求链表长度
	public static int listLength(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

}
