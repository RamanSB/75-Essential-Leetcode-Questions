package linkedlist;

/**
 * Draw it out, start with 3 nodes. Keep track of the previous node, initially set prev to null.
 *
 * Space complexity O(1) - modifying list in place.
 * Time complexity: O(n) - iterating through all n elements.
 *
 * My code may be excessive and there are cleaner solutions with less lines, however I programmed the thought in my head.
 *
 * null -> 1 -> 2 -> 3
 *
 * 1)
 *  prev = null
 *  curr = head (1)
 *  next = curr.next = 2
 *
 *  if(curr == null || next == null) { return curr }
 *  else keep on setting:
 *      curr.next = prev;
 *      prev = curr
 *      curr = next
 *      next = curr.next
 *
 * when next is null, curr will be 3 and prev will be 2 - the loop would have terminated however we would need to manually set
 * 3.next to point 2 (curr.next = prev) and then we are done, return current.
 *
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode prev = null;
            ListNode current = head;
            ListNode next = current.next;
            while (next != null) {
                current.next = prev;
                prev = current;
                current = next;
                next = current.next;
            }
            current.next = prev;
            return current;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
