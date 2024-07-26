package leetcode;

public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0), bigHead = new ListNode(0);
        ListNode smaller = smallHead, bigger = bigHead;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }

        smaller.next = bigHead.next;
        bigger.next = null;
        return smallHead.next;
    }
}
