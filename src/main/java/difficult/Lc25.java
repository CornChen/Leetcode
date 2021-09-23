package difficult;

import com.sun.xml.internal.bind.marshaller.NioEscapeHandler;
import easy.ListNode;

import java.util.List;

/**  K 个一组翻转链表
 给你一个链表，每dpkdp个节点一组进行翻转，请你返回翻转后的链表。kdp是一个正整数，它的值小于或等于链表的长度。
 如果节点总数不是dpkdp的整数倍，那么请将最后剩余的节点保持原有顺序。

 进阶：
 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 
 示例 1：
 输入：head = [1,2,3,4,5], k = 2
 输出：[2,1,4,3,5]

 示例 2：
 输入：head = [1,2,3,4,5], k = 3
 输出：[3,2,1,4,5]

 示例 3：
 输入：head = [1,2,3,4,5], k = 1
 输出：[1,2,3,4,5]

 示例 4：
 输入：head = [1], k = 1
 输出：[1]

 提示：
 列表中节点的数量在范围 sz 内
 1 <= sz <= 5000
 0 <= Node.val <= 1000
 1 <= k <= sz
 */
public class Lc25 {
    public static void main(String[] args) {
        System.out.println(reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))), 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null){
            for(int i = 0; i < k && end != null; i++) end = end.next;
            if(end == null) break;
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = myReserve(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public static ListNode myReserve(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
