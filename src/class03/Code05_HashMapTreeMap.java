package class03;

import java.util.HashMap;
import java.util.TreeMap;

public class Code05_HashMapTreeMap {

	public static class Node {
		public int value;

		public Node(int v) {
			value = v;
		}
	}

	// (K V)表
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("zuochengyun", "我是左程云");
		System.out.println(map.containsKey("zuochengyun"));
		System.out.println(map.containsKey("zuo"));
		System.out.println(map.get("zuochengyun"));

		map.put("zuochengyun", "他是左程云");
		System.out.println(map.get("zuochengyun"));

//		map.remove("zuochengyun");
//		System.out.println(map.containsKey("zuochengyun"));
//		System.out.println(map.get("zuochengyun"));

		String test1 = "zuochengyun";
		String test2 = "zuochengyun";
		System.out.println(map.containsKey(test1));
		System.out.println(map.containsKey(test2));

		HashMap<Integer, String> map2 = new HashMap<>();
		map2.put(1234567, "我是1234567");

		Integer a = 1234567;
		Integer b = 1234567;

		System.out.println(a == b);
		System.out.println(map2.containsKey(a));
		System.out.println(map2.containsKey(b));

		// 哈希表中Integer等基础类型的封装类，是按值传递，内存占用情况是Integer的大小(key)+Integer的大小(value)

		Node node1 = new Node(1);
		Node node2 = new Node(1);
		HashMap<Node, String> map3 = new HashMap<>();
		map3.put(node1, "我进来了！");
		System.out.println(map3.containsKey(node1));
		System.out.println(map3.containsKey(node2));

		// 这种情况，哈希表是按引用地址传递，哈希表的内存占用情况是Node节点的内存地址，也就是8字节(key)+8字节(value)=16字节

		System.out.println("===================");
		// TreeMap是有序表，时间复杂度是O(logN);哈希表的时间复杂度是O(1),但是有序表比哈希表的虽然时间复杂度大一些，功能更丰富
		TreeMap<Integer, String> treeMap1 = new TreeMap<>();

		treeMap1.put(3, "我是3");
		treeMap1.put(0, "我是3");
		treeMap1.put(7, "我是3");
		treeMap1.put(2, "我是3");
		treeMap1.put(5, "我是3");
		treeMap1.put(9, "我是3");

		System.out.println(treeMap1.containsKey(7));
		System.out.println(treeMap1.containsKey(6));
		System.out.println(treeMap1.get(3));

		treeMap1.put(3, "他是3");
		System.out.println(treeMap1.get(3));

		treeMap1.remove(3);
		System.out.println(treeMap1.get(3));

		System.out.println(treeMap1.firstKey());
		System.out.println(treeMap1.lastKey());
		// <=5 离5最近的key告诉我
		System.out.println(treeMap1.floorKey(5));
		// <=6 离6最近的key告诉我
		System.out.println(treeMap1.floorKey(6));
		// >=5 离5最近的key告诉我
		System.out.println(treeMap1.ceilingKey(5));
		// >=6 离6最近的key告诉我
		System.out.println(treeMap1.ceilingKey(6));

		// 有序表的引用传递，下述代码会报错，因为需要将key转换为可以比较的，所以需要重写Node的equals的方法
//		Node node3 = new Node(3);
//		Node node4 = new Node(4);
//		TreeMap<Node, String> treeMap2 = new TreeMap<>();
//		treeMap2.put(node3, "我是node3");
//		treeMap2.put(node4, "我是node4");

	}

}
