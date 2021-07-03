import java.util.ArrayList;
import java.util.List;

public class Lc206 {
    public static void main(String[] args) {
        System.out.println(reverseList(null));
    }

    /** 反转链表
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */
    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        List<Integer> values = new ArrayList<>();
        while(head != null){
            values.add(head.val);
            head = head.next;
        }
        ListNode list = new ListNode(values.get(values.size() - 1));
//        忘记保留返回值
        ListNode res = list;
        for(int i = values.size() - 2; i >= 0; i--){
            list.next = new ListNode(values.get(i));
//            忘记右移一位
            list = list.next;
        }
        return res;
    }
}
