import java.util.List;

public class Lc141 {
    public static void main(String[] args) {
        System.out.println(hasCycle(new ListNode(1)));
    }


    public static boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode l1 = head;
        ListNode l2 = head;
        while(l2.next != null && l2.next.next != null){
            l1 = l1.next;
            l2 = l2.next.next;
            if(l1 == l2) return true;
        }
        return false;
    }
}
