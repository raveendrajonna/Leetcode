        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode rev = reverse(next);
        ListNode temp1 = head;
        ListNode temp2 = rev;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(temp1 != null && temp2 != null)
        {
            ListNode next1 = temp1.next;
            ListNode next2 = temp2.next;
            temp.next = temp1;
            temp1.next = temp2;
            
            temp = temp2;
            temp1 = next1;
            temp2 = next2;           
        }
        
        while(temp1 != null)
        {
            temp.next = temp1;
            temp = temp.next;
            temp1 = temp1.next;
        }
        
               
    }
    
    public ListNode reverse(ListNode head)
    {
      ListNode prev = null;
      ListNode cur = head;
      ListNode next = null;
      while(cur != null)
      {
         next = cur.next;
         cur.next = prev;
         prev = cur;
         cur = next;          
      }    
      return prev;  
    }
}
