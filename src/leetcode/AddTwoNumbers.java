package leetcode;

public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode temp = new ListNode();
            ListNode head = temp;
            int curr = 0, carry = 0;
            while(l1 != null && l2 != null) {
                int sum = l1.val + l2.val + carry;
                curr = sum%10;
                carry = sum/10;

                temp.next = new ListNode(curr);
                temp = temp.next;
                l1 = l1.next;
                l2 = l2.next;
            }

            while(l1 != null) {
                int sum = l1.val + carry;
                curr = sum%10;
                carry = sum/10;

                temp.next = new ListNode(curr);
                temp = temp.next;
                l1 = l1.next;
            }

            while(l2 != null) {
                int sum = l2.val + carry;
                curr = sum%10;
                carry = sum/10;

                temp.next = new ListNode(curr);
                temp = temp.next;
                l2 = l2.next;
            }

            if(carry != 0) {
                temp.next = new ListNode(carry);
                temp = temp.next;
            }

            return head.next;
        }
    }
}
