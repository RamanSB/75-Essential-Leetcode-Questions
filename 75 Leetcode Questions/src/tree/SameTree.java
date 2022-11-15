package tree;

/**
 * Consider two trees:
 *
 *        1                1
 *       / \              / \
 *      2   3            2   3
 *
 *
 * Because the tree is small you may attempt to do it iteratively, but imagine a much larger tree doing this iteratively
 * will be tricky. So let's think of a recursive method / pattern we can look out for.
 *
 * For trees to be identical, let's consider the 1st node on each tree:
 *  a) both must be non-null or both must be null (the latter implies both trees are empty and thus identical)
 *      1) if both are non-null there values must be equal.
 *      2) If both nodes are null, we can imagine this occurring if we check the left/right child of our leaf nodes (leaf
 *      nodes do not have any children and therefore we can use this as a case to ascertain that the nodes are equal and we have
 *      got to the end of our recursion) - this will be used as our base case. (Line 39-41)
 *
 *  b) if the above is not true, then we can return false. So...
 *      1) if a!= null && b==null or b!=null && a == null, we can return false
 *
 *  Space Complexity: We make 2 recursive calls each time we descend through the depths of the tree. So for a tree of depth D
 *  where D = log_(base2)(N+1), we will have O(2^(D)) calls which is ~ N O(N)
 *  Time Complexity: Traversing the rees, we will go through n * 2 nodes O(2n) ~ O(n)
 *
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q!=null) {
            return false;
        } else if (q==null && p!=null) {
            return false;
        } else {
            return isTreeIdentical(p, q);
        }
    }

    private boolean isTreeIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }  else if (a == null && b != null) {
            return false;
        } else if (b == null && a!= null) {
            return false;
        }
        else {
            return a.val == b.val && isTreeIdentical(a.left, b.left) && isTreeIdentical(a.right,b.right);
        }
    }

    public static void main(String[] args) {

    }
}
