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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode f = head;
        for(int i=0; i<n; i++)
        {
            f = f.next;
        }
        
        ListNode s = head;
        ListNode prev = dummy;
        
        while(f != null)
        {
            prev = s;
            s = s.next;
            f = f.next;
        }
        prev.next = prev.next.next;
        
        return dummy.next;
    }
}