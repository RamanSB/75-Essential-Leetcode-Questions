package graph;

import java.util.*;

/**
 * Undirected connected graph.
 *
 * There exists a path from a given node to all other nodes - connected.
 * We should ideally find a way of keeping track of a nodes clone, the easiest way to do this would be to have a 1-1 mapping
 * of Map<Node, [Cloned]Node>.
 *
 * Perform DFS, when visiting a node - check if that node is a key in the cloneGraph if not, create a new Node with the same value
 * but an empty neighbors list. Add this new cloned node as a value against the original node as a key.
 *
 * Iterate through and the neighbors, do the same if a neighbor has not been cloned. Then work on adding the neighbors in.
 *
 * Return cloneMap.get(originalNode);
 *
 * Time complexity: O(number of nodes + number of edges) - DFS Traversal.
 * Space complexity: O(n), n nodes.
 */
public class CloneGraph {

    Map<Node, Node> cloneGraph = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        if (node.neighbors.isEmpty()) {
            return new Node(node.val);
        } else {
            performDfs(node);
            return cloneGraph.get(node);
        }
    }


    public void performDfs(Node n) {
        Deque<Node> stack = new ArrayDeque<>();
        System.out.print("Visited: ");
        stack.push(n);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (!cloneGraph.containsKey(currentNode)) {
                System.out.print("Cloning node " + currentNode.val + "\n");
                Node clonedNode = new Node(currentNode.val, new ArrayList<>());
                cloneGraph.put(currentNode, clonedNode);
            }
            for (Node neighbor : currentNode.neighbors) {
                if (!cloneGraph.containsKey(neighbor)) {
                    cloneGraph.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    stack.push(neighbor);
                }
                if (!cloneGraph.get(currentNode).neighbors.contains(cloneGraph.get(neighbor))) {
                    cloneGraph.get(currentNode).neighbors.add(cloneGraph.get(neighbor));
                }
            }
        }
        System.out.println("DFS Complete");
    }

    class Node {
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
}
