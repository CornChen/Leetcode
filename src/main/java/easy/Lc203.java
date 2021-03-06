package easy;

public class Lc203 {
    public static void main(String[] args) {
        System.out.println(removeElements(new ListNode(7), 7));
    }

    /** 移除链表元素
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *
     * 示例 1：
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     *
     * 示例 2：
     * 输入：head = [], val = 1
     * 输出：[]
     *
     * 示例 3：
     * 输入：head = [7,7,7,7], val = 7
     * 输出：[]
     *
     * 提示：
     * 列表中的节点在范围 [0, 104] 内
     * 1 <= Node.val <= 50
     * 0 <= k <= 50
     */
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        // while(head.val == val) head = head.next
        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode l1 = head;
        while(head != null && head.next != null){
            if(head.next.val == val) head.next = head.next.next;
//            忘记更新head
            else head = head.next;
        }
        return l1;
    }
}
