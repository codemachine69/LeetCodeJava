package leetcode;

public class ReverseLL206 {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseListRec(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
}
