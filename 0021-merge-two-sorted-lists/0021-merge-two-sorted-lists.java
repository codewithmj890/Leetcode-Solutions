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
        
        // --- Build List 1: [1 -> 3 -> 5] ---
        ListNode l1_node3 = new ListNode(5);
        ListNode l1_node2 = new ListNode(3, l1_node3);
        ListNode list1 = new ListNode(1, l1_node2);
        
        // --- Build List 2: [2 -> 4 -> 6] ---
        ListNode l2_node3 = new ListNode(6);
        ListNode l2_node2 = new ListNode(4, l2_node3);
        ListNode list2 = new ListNode(2, l2_node2);
        
        // --- Merge them ---
        ListNode mergedHead = solver.mergeTwoLists(list1, list2);
        
        // --- Print the result ---
        System.out.print("Merged List: ");
        printList(mergedHead);
    }
    
    // Helper method to print linked lists cleanly
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // attach whichever list still has leftover nodes
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}