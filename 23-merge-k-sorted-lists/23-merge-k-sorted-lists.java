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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x,y)->(x.val-y.val));
        for(ListNode node : lists)
        {
            if(node != null)
              pq.add(node);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(pq.size() > 0)
        {
           prev.next = pq.peek();
           prev = prev.next;
           ListNode cur = pq.remove();
           if(cur.next != null)
               pq.add(cur.next);
        }
        prev.next= null;
        return dummy.next;
    }
}