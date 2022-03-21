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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead =null;
       // ListNode prev = null;
        Stack<ListNode> stk = new Stack<>();
        
        ListNode cur = head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(cur != null)
        {
            int cnt=0;
            while(cnt<k && cur != null)
            {
                stk.push(cur);
                cur = cur.next;
                cnt++;
            }
            
            if(cnt == k)
            {
                //need to reverse;
                while(stk.size() > 0)
                {

                        prev.next = stk.pop();
                        prev = prev.next;
                }
                if(cur == null)
                    prev.next = null;
                
            }
            else
            {
                while(stk.size() > 1)
                    stk.pop();
                 prev.next = stk.pop();
            }
        }
        
        return dummy.next;
    }
}