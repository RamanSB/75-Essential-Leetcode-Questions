package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * The maximum depth of a tree can be found in many ways - the easiest solution is a recursive one.
 * <p>
 * BFS can also be used - You can iterate through each level of the tree storing each level in an array, the
 * max depth will be the size of array, each level will be included. Number of levels = max depth.
 */
public class MaximumDepth {

    private int maxDepth(TreeNode root) {
        return bfsWithDepth(root);
    }

    private int bfsWithDepth(TreeNode root) {
        List<List<TreeNode>> levels = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0, next;
        TreeNode currentNode = null;
        while (!queue.isEmpty()) {
            next = queue.size();
            depth++;

            for (int i = 0; i < next; i++) { // This ensures we add all Nodes in 1 level of the Tree before moving on to the next level.
                // When this for loop is completed all elements from the previous level will have been removed.
                currentNode = queue.poll();
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            System.out.println(queue);
            levels.add(new ArrayList<>(queue));
        }
        System.out.println("------------------------------");
        System.out.println("---------Levels-------");
        levels.stream().forEach(System.out::println);
        return depth;
    }

    public int recursiveDfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        } else {
            System.out.print(root.val + ", ");
            return Math.max(recursiveDfs(root.left, depth + 1), recursiveDfs(root.right, depth + 1));
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(14);
        root.right.right.right = new TreeNode(25);
        MaximumDepth instance = new MaximumDepth();
        System.out.println(instance.maxDepth(root));
    }

}


