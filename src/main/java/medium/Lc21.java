package medium;

import easy.ListNode;

import java.util.List;

/** 合并两个有序链表

 */

public class Lc21 {
    public static void main(String[] args) {
        System.out.println(mergeTwoLists2(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4)))));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        if(l1.val > l2.val) return mergeTwoLists(l2, l1);
        ListNode res = l1;
//        while (l1.next != null && l2.next != null){
        while (l1.next != null && l2 != null){
            ListNode tmp = new ListNode();
//            if(l1.val <= l2.val){
            if(l2.val < l1.next.val){
                tmp.val = l2.val;
                tmp.next = l1.next;
                l1.next = tmp;
                l1 = l1.next;
                l2 = l2.next;
            }else {
//                tmp.val = l1.val;
//                tmp.next = l2.next;
//                l2.next = tmp;
//                l2 = l2.next;
                l1 = l1.next;
            }
        }
        if(l1.next == null) l1.next = l2;
        else {
            l1 = l1.next;
        }
        return res;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
