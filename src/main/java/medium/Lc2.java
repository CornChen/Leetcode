package medium;

/** 两数相加
 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 请你将两个数相加，并以相同形式返回一个表示和的链表。
 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 
 示例 1：
 输入：l1 = [2,4,3], l2 = [5,6,4]
 输出：[7,0,8]
 解释：342 + 465 = 807.

 示例 2：
 输入：l1 = [0], l2 = [0]
 输出：[0]

 示例 3：
 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 输出：[8,9,9,9,0,0,0,1]
 
 提示：
 每个链表中的节点数在范围 [1, 100] 内
 0 <= Node.val <= 9
 题目数据保证列表表示的数字不含前导零
 */
public class Lc2 {
    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        System.out.println(addTwoNumbers(
                new ListNode(1,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9,
                                                                new ListNode(9,
                                                                        new ListNode(9,
                                                                                new ListNode(9,
                                                                                        new ListNode(9)))))))))),
                new ListNode(9)));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int i1, i2, cur = 0, sum = 0;
        ListNode pre = new ListNode(0);
        ListNode head = pre;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                sum = (l1.val + l2.val + cur) % 10;
                cur = l1.val + l2.val + cur > 9 ? 1 : 0;
//                应当把l1，l2的指针右移放在对应的判断中，否则会产生空指针
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 != null){
                sum = (l1.val + cur) % 10;
                cur = l1.val + cur > 9 ? 1 : 0;
                l1 = l1.next;
            }else {
                sum = (l2.val + cur) % 10;
                cur = l2.val + cur > 9 ? 1 : 0;
                l2 = l2.next;
            }
            pre.val = sum;
//            忘记判断是否需要初始化pre.next节点，否则会在末尾多余一个为0的节点
            if(l1 != null || l2 != null || cur != 0) {
                pre.next = new ListNode();
                pre = pre.next;
            }
        }
        if(cur == 1) pre.val = 1;
        return head;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        long i = 0, j = 0, sum = 0;
        i = ListNode2Long(l1);
        j = ListNode2Long(l2);
        sum = i + j;
        ListNode head = new ListNode((int) (sum % 10));
//        忘记保留头节点
        ListNode list = head;
        sum /= 10;
        while(sum > 0){
            list.next = new ListNode((int) (sum % 10));
//          忘记list后移一位
            list = list.next;
            sum /= 10;
        }
//        return list; 忘记替换掉返回值
        return head;
    }
    public static long ListNode2Long(ListNode l) {
        long i = 0, count = 1;
        while(l != null){
            i += count * l.val;
            count *= 10;
            l = l.next;
        }
        return i;
    }
}
