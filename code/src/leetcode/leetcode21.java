package leetcode;

public class leetcode21 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                break; // 容易忘记
            } else if (l2 == null) {
                cur.next = l1;
                break;
            } else if (l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy; // 指向合并过程中的当前节点
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = l1; // cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2; // cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l2 != null) {
            cur.next = l2;
        }

        if (l1 != null) {
            cur.next = l1;
        }
        return dummy.next;
    }
}
