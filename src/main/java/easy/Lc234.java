package easy;

import java.util.ArrayList;
import java.util.List;

public class Lc234 {
    /** 回文链表
     请判断一个链表是否为回文链表。

     示例 1:
     输入: 1->2
     输出: false

     示例 2:
     输入: 1->2->2->1
     输出: true

     进阶：
     你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1)));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        List<Integer> value = new ArrayList<>();
        while(head != null){
            value.add(head.val);
            head = head.next;
        }
        int i = 0, j = value.size() - 1;
        while(i < j){
            if(value.get(i++) != value.get(j--)) return false;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) slow = slow.next;
        while(slow != null && pre != null){
            if(slow.val != pre.val) return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
