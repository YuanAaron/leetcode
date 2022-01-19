package leetcode;

public class leetcode21 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // 总结：
    // 时间复杂度：O(m+n)
    // 空间复杂度：mergeTwoLists1、mergeTwoLists2、mergeTwoLists3为O(1)，mergeTwoLists为O(m+n)

    // 推荐写法：
    // 如果空间复杂度可以为O(m+n)，推荐mergeTwoLists递归写法
    // 如果空间复杂度为O(1)，推荐mergeTwoLists1使用虚拟头节点写法

    // 递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 不使用虚拟头节点
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur = null,head = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (cur == null) {
                    head = l1;
                    cur = l1;
                } else {
                    cur.next = l1;
                    cur = cur.next;
                }
                l1 = l1.next;
            } else {
                if (cur == null) {
                    head = l2;
                    cur = l2;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                }
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
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
