package difficult;

import easy.ListNode;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.*;

/** 合并K个升序链表
 给你一个链表数组，每个链表都已经按升序排列。
 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 
 示例 1：
 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 输出：[1,1,2,3,4,4,5,6]
 解释：链表数组如下：
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 将它们合并到一个有序链表中得到。
 1->1->2->3->4->4->5->6

 示例 2：
 输入：lists = []
 输出：[]

 示例 3：
 输入：lists = [[]]
 输出：[]
 
 提示：
 k == lists.length
 0 <= k <= 10^4
 0 <= lists[i].length <= 500
 -10^4 <= lists[i][j] <= 10^4
 lists[i] 按 升序 排列
 lists[i].length 的总和不超过 10^4
 */
public class Lc23 {

    public static void main(String[] args) {
//        ListNode[] list = new ListNode[]{new ListNode(1,new ListNode(4,new ListNode(5))), new ListNode(1,new ListNode(3, new ListNode(4)))};
        ListNode[] list = new ListNode[]{};
        System.out.println(mergeKLists(list));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(ListNode ln : lists){
            while (ln != null){
                list.add(ln.val);
                ln = ln.next;
            }
        }
        if(list.isEmpty()) return null;
        Collections.sort(list);
        ListNode head = new ListNode();
        ListNode res = head;
        for(int i : list){
            head.next = new ListNode(i);
            head = head.next;
        }
        return res.next;
    }

}
