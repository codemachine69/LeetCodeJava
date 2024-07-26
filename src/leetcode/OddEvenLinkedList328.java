package leetcode;

public class OddEvenLinkedList328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1), evenHead = new ListNode(-1);
        ListNode odd = oddHead, even = evenHead;
        int cnt = 1;

        while (head != null) {
            if (cnt % 2 == 0) {
                even.next = new ListNode(head.val);
                even = even.next;
            } else {
                odd.next = new ListNode(head.val);
                odd = odd.next;
            }
            head = head.next;
            cnt++;
        }

        odd.next = evenHead.next;
        return oddHead.next;
    }
}
