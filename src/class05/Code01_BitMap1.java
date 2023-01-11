package class05;

import java.util.HashSet;

// 这个类的实现是错误的
// 请问为什么？ 1是int类型，只有32位，如果要移动42位，那么int就会出错
public class Code01_BitMap1 {

	public static class BitMap {

		private long[] bits;

		// (max+64) >> 6  = (max+64)/64    标识0，需要1个long类型
		// 向上取余=(a+b-1)/b
		public BitMap(int max) {
			bits = new long[(max + 64) >> 6];
		}

		// (num/64) = 属于哪个整数
		// (num & 63) = 整数的哪位 = num % 64
		// bits[num >> 6] |= (1 << (num & 63) = 将num所在的位置标为1
		public void add(int num) {
			bits[num >> 6] |= (1 << (num & 63));
		}

		// (1 << (num & 63) + 取反 + 与运算
		public void delete(int num) {
			bits[num >> 6] &= ~(1 << (num & 63));
		}

		public boolean contains(int num) {
			return (bits[num >> 6] & (1 << (num & 63))) != 0;
		}

	}

	public static void main(String[] args) {
		System.out.println("测试开始！");
		int max = 10000;
		BitMap bitMap = new BitMap(max);
		HashSet<Integer> set = new HashSet<>();
		int testTime = 10000000;
		for (int i = 0; i < testTime; i++) {
			int num = (int) (Math.random() * (max + 1));
			double decide = Math.random();
			if (decide < 0.333) {
				bitMap.add(num);
				set.add(num);
			} else if (decide < 0.666) {
				bitMap.delete(num);
				set.remove(num);
			} else {
				if (bitMap.contains(num) != set.contains(num)) {
					System.out.println("Oops!");
					break;
				}
			}
		}
		for (int num = 0; num <= max; num++) {
			if (bitMap.contains(num) != set.contains(num)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("测试结束！");
	}

}
