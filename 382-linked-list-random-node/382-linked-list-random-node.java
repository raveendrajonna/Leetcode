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
    int cnt=0;
    Random random;
    ListNode head;
    public Solution(ListNode head) {
        ListNode temp = head;
        this.head = head;
        while(temp != null)
        {
            temp = temp.next;
            cnt++;
        }
        random = new Random();
    }
    
    public int getRandom() {
       int idx = random.nextInt(cnt);
       int i=0;
        ListNode temp = head;
        while(i < idx)
        {
            i++;
            temp = temp.next;
            
        }
        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */