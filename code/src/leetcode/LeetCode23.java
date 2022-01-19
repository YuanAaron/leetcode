package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode23 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) {
//            return null;
//        }
        Queue<ListNode> queue = new PriorityQueue<>(/*lists.length,*/ (o1, o2) -> o1.val - o2.val);
        ListNode dummy = new ListNode(0);
        ListNode cur =dummy;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;

            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = {};
        System.out.println(mergeKLists(lists));
    }
}
