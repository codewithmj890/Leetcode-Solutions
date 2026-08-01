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
class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Test 1: Standard case. Remove 2nd from end (the 4)
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.print("Original List 1: ");
        printList(head1);
        ListNode result1 = solver.removeNthFromEnd(head1, 2);
        System.out.print("Result 1: ");
        printList(result1); // Expected: 1 -> 2 -> 3 -> 5 -> null
        
        System.out.println("-------------------");
        
        // Test 2: The Edge Case. Remove 1st from end of a 1-node list
        // 1
        ListNode head2 = new ListNode(1);
        System.out.print("Original List 2: ");
        printList(head2);
        ListNode result2 = solver.removeNthFromEnd(head2, 1);
        System.out.print("Result 2: ");
        printList(result2); // Expected: null
    }
    
    // Helper method to print the list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// Your exact LeetCode solution
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}