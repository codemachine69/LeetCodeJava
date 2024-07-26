package leetcode;

public class DesignBrowserHistory1472 {
    Node head, orig;

    private class Node {
        String name;
        Node next, prev;

        Node(String name) {
            this.name = name;
        }
    }

    public DesignBrowserHistory1472(String homepage) {
        head = new Node(homepage);
        orig = head;
    }

    public void visit(String url) {
        head.next = new Node(url);
        Node temp = head;
        head = head.next;
        head.prev = temp;
    }

    public String back(int steps) {
        while (steps > 0 && head.prev != null) {
            Node temp = head;
            head = head.prev;
            head.next = temp;
            steps--;
        }
        return head.name;
    }

    public String forward(int steps) {
        while (steps > 0 && head.next != null) {
            Node temp = head;
            head = head.next;
            head.prev = temp;
            steps--;
        }
        return head.name;
    }
}
