package medium;

import easy.ListNode;

/** 删除链表的倒数第 N 个结点
 给你一个链表，删除链表的倒数第,n,个结点，并且返回链表的头结点。
 进阶：你能尝试使用一趟扫描实现吗？

 示例 1：
 输入：head = [1,2,3,4,5], n = 2
 输出：[1,2,3,5]

 示例 2：
 输入：head = [1], n = 1
 输出：[]

 示例 3：
 输入：head = [1,2], n = 1
 输出：[1]

 提示：
 链表中结点的数目为 sz
 1 <= sz <= 30
 0 <= Node.val <= 100
 1 <= n <= sz
 https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
 */
public class Lc19 {
    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(new ListNode(1),1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode fast = head, pre = new ListNode(0);
        pre.next = head;
        ListNode slow = pre;
        for(int i = 0; i < n; i++) fast = fast.next;
//        while(fast.next != null){
//        while(fast != null && fast.next != null){
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
//        if(fast == null){
//            return pre.next.next;
//        }else {
//            slow.next = slow.next.next;
//            return pre.next;
//        }
        slow.next = slow.next.next;
        return pre.next;
    }
}
