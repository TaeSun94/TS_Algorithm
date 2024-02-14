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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode result = new ListNode(head.val);
        ListNode current = result;
        while(head.next != null) {
            head = head.next;
            if(head.val != current.val) {
                current.next = new ListNode(head.val);
                current = current.next;
            }
        }
        return result;
    }
}
