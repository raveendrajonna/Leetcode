/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    boolean cycle = false;
    public ListNode detectCycle(ListNode head) {

        ListNode s = head;
        ListNode f= head;
        
        while(f != null && f.next != null)
        {
           s = s.next;
           f = f.next.next;
            if(s == f)
             {
                s = head; // reset slow to head
                while(s != f ){ // run loop until again fast & slow don't collab
                    s = s.next; // moving slow by 1
                    f = f.next; // moving fast by 1 as well
                }
                return s; // Or return fast same thing, they will return the tail where cycle starts
            }
        }
        
        return null;
 
    }
}