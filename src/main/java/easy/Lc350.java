package easy;

import java.util.*;

/** 两个数组的交集 II
 给定两个数组，编写一个函数来计算它们的交集。

 示例 1：
 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 输出：[2,2]

 示例 2:
 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出：[4,9]

 说明：
 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 我们可以不考虑输出结果的顺序。

 进阶：
 如果给定的数组已经排好序呢？你将如何优化你的算法？
 如果nums1的大小比nums2小很多，哪种方法更优？
 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Lc350 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            if (!map1.containsKey(num)) map1.put(num, 1);
            else map1.put(num, map1.get(num) + 1);
        }
        for (int num : nums2) {
            if (!map2.containsKey(num)) map2.put(num, 1);
            else map2.put(num, map2.get(num) + 1);
        }
        if (map1.size() < map2.size()) {
            for (Integer key : map1.keySet()) {
                // if (!map2.containsKey(key)) break;  另一个set中没有此key时应将此key移除
                // if (!map2.containsKey(key)) map1.remove(key); 移除后应跳过后面步骤
                if (!map2.containsKey(key)) map1.put(key,0);
                else {
                    if (map2.get(key) < map1.get(key)) map1.put(key, map2.get(key));
                    for(int i = 0; i < map1.get(key); i++) list.add(key);
                }
            }
        } else {
            for (Integer key : map2.keySet()) {
                // if (!map1.containsKey(key)) break;  另一个set中没有此key时应将此key移除
                // if (!map1.containsKey(key)) map2.remove(key); 移除后应跳过后面步骤
                if (!map1.containsKey(key)) map2.put(key, 0);
                else {
                    if (map1.get(key) < map2.get(key)) map2.put(key, map1.get(key));
                    for (int i = 0; i < map2.get(key); i++) list.add(key);
                }
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        // 灵性写法
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            // 少做一个判断
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
