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
        
        // --- Build the list: 1 -> 2 -> 3 -> 4 ---
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.print("Original List 1: ");
        printList(head1);
        
        solver.reorderList(head1);
        
        System.out.print("Reordered List 1: ");
        printList(head1); // Expected: 1 -> 4 -> 2 -> 3
        
        System.out.println("-------------------");
        
        // --- Build the list: 1 -> 2 -> 3 -> 4 -> 5 ---
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.print("Original List 2: ");
        printList(head2);
        
        solver.reorderList(head2);
        
        System.out.print("Reordered List 2: ");
        printList(head2); // Expected: 1 -> 5 -> 2 -> 4 -> 3
    }
    
    // Helper method to print the list easily
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// 2. Your exact LeetCode solution
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // Step 1: Find the middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half
        ListNode secondHead = slow.next;
        slow.next = null; 
        
        ListNode prev = null, curr = secondHead;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        secondHead = prev; 
        
        // Step 3: Merge the two halves alternately
        ListNode first = head, second = secondHead;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}