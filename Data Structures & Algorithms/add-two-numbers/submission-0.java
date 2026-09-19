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
      ListNode dummy = new ListNode(0);
      ListNode sum = dummy;
      int carry = 0;

      while(l1 != null || l2 != null){
        int l1val = (l1 != null) ? l1.val : 0;
        int l2val = (l2 != null) ? l2.val : 0;

        int curr_sum = l1val + l2val + carry;
        carry = curr_sum / 10;
        int lastD = curr_sum % 10;

        ListNode newNode = new ListNode(lastD);
        sum.next = newNode;

        if(l1 != null) l1 = l1.next;
        if(l2 != null) l2 = l2.next;
        sum = sum.next;
      }

      if(carry > 0){
        ListNode newNode = new ListNode(carry);
        sum.next = newNode;
        sum = sum.next;
      }

      return dummy.next;  
      
    }
}
