import java.util.List;

public class Lc83 {
    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ListNode(1,new ListNode(1, new ListNode(2)))));
    }

//  Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
//        此时cur指向最后一个元素，应返回head
//        return cur;
        return head;
    }
}

