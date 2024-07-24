package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph133 {

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Node dfs(Node node, HashMap<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);
        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node nei : node.neighbors) {
            clone.neighbors.add(dfs(nei, map));
        }
        return clone;
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
}
