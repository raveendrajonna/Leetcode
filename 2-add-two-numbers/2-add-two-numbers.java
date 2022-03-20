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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry=0;
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        
        while(t1 != null || t2 != null)
        {
            int val = (t1==null ? 0 :t1.val )+  (t2 ==null ? 0: t2.val) + carry;
            carry = val/10;
            val = val%10;
            prev.next = new ListNode(val);
            prev = prev.next;
            t1 = t1 != null ? t1.next : t1;
            t2 = t2 != null ? t2.next : t2;
        }
        
        if(carry != 0)
        {
            prev.next = new ListNode(carry);
        }
        
        return head.next;
    }
}