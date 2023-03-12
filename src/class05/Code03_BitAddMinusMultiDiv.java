package class05;

// 用位运算实现加减乘除
// 测试链接：https://leetcode.com/problems/divide-two-integers
public class Code03_BitAddMinusMultiDiv {

	// a+b = ab无进位相加 + ab的进位信息
	public static int add(int a, int b) {
		int sum = a;
		while (b != 0) {
			sum = a ^ b; // 异或运算=无进位相加信息 -> sum
			b = (a & b) << 1; // (a与b + 左移一位)=进位信息 -> b'
			a = sum; // a -> a' 无进位相加信息
		}
		return sum;
	}

	public static int negNum(int n) {
		return add(~n, 1);
	}

	// 减法： a-b= a+(b的相反数) = add(a,add(~b,1))
	public static int minus(int a, int b) {
		return add(a, negNum(b));
	}

	// 乘法，理解乘法运算，要回忆小学怎么学习乘法的
	// 0110 * 0111 = 0110 + 01100 + 01100
	// 用b的二进制位如果为1，则把a的二进制抄下来；
	// b的二进制每动一位，a的二进制都在后面补0
	public static int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) { // b & 1 = 检查b的第一位是不是1，如果是则加a
				res = add(res, a);
			}
			a <<= 1;
			b >>>= 1; // 无符号右移，如果是有符号右移，如果是负数，则代码就死循环了
		}
		return res;
	}

	public static boolean isNeg(int n) {
		return n < 0;
	}

	// 除法，支持向下取整
	public static int div(int a, int b) {
		int x = isNeg(a) ? negNum(a) : a;
		int y = isNeg(b) ? negNum(b) : b;
		int res = 0;
		// 先将两个数转成正数
		for (int i = 30; i >= 0; i = minus(i, 1)) { // X一定是非负的，所以是从30位开始右移
			if ((x >> i) >= y) {
				res |= (1 << i);
				x = minus(x, y << i);
			}
		}
		// 补符号位
		return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
	}

	public static int divide(int a, int b) {
		// 系统最小值，无法转成绝对值，它的绝对值还是它自己
		// a和b都是系统最小
		if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
			return 1;
		} else if (b == Integer.MIN_VALUE) {
			// b是系统最小，a不是系统最小
			return 0;
		} else if (a == Integer.MIN_VALUE) {
			// a是系统最小，b不是系统最小
			if (b == negNum(1)) { // 规定：系统最小 / -1 = 系统最大
				return Integer.MAX_VALUE;
			} else {
				// a/b
				// (a+1)/b=c
				// a-(b*c)=d
				// d/b = e
				// ans = c+e
				//----
				// 系统最小a 得到系统最大的相反数 c
				// c除b=d
				// a-b*d=e
				// e/b=f
				// 最后的结果=d+f
				int c = div(add(a, 1), b);
				return add(c, div(minus(a, multi(c, b)), b));
			}
		} else {
			return div(a, b);
		}
	}

	public static void main(String[] args) {
		int divide = divide(-9, 4);
		System.out.println(divide);
	}
}
