package leetcode;

import java.util.HashMap;

public class CopyListRandomPointer138 {
    HashMap<Node, Node> hm = new HashMap<>(); //used only for recursive approach

    public Node copyRandomList(Node head) {
        if(head == null) return head;

        Node temp = head, next;

        while(temp != null) {
            next = temp.next;
            Node copy = new Node(temp.val);
            temp.next = copy;
            copy.next = next;
            temp = next;
        }

        temp = head;
        while (temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node copyHead = new Node(-1);
        Node copyIter = copyHead;
        while(temp != null) {
            next = temp.next.next;
            Node copy = temp.next;
            copyIter.next = copy;
            copyIter = copy;
            temp.next = next;
            temp = next;
        }
        return copyHead.next;
    }

    public Node copyRandomList_iter(Node head) {
        if (head == null) return head;

        Node temp = head;
        Node res = new Node(-1);
        Node curr = res;
        HashMap<Node, Node> hm = new HashMap<>();
        while (temp != null) {
            Node copy = new Node(temp.val);
            curr.next = copy;
            curr = curr.next;

            hm.put(temp, copy);
            temp = temp.next;
        }

        temp = head;
        curr = res.next;

        while (temp != null) {
            curr.random = hm.get(temp.random);
            curr = curr.next;
            temp = temp.next;
        }

        return res.next;
    }

    public Node copyRandomList_recursive(Node head) {
        if (head == null) return head;

        Node copy = new Node(head.val);
        hm.put(head, copy);
        copy.next = copyRandomList_recursive(head.next);
        copy.random = hm.get(head.random);

        return copy;
    }
}
