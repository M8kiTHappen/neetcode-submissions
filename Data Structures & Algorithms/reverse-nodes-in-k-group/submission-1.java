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
        if (head.next == null) {return head;}
        if (k <= 1) {return head;}

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null){
            boolean space = checkHasSpace(k, curr);
            if (space){
                prev = reverse(prev, curr, k);
                curr = prev.next;
            } else {
                break;
            }
        }
        return dummy.next;
    }

    private boolean checkHasSpace(int k, ListNode curr){
        for(int i = 1; i <= k; i++){
            if(curr == null){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    private ListNode reverse(ListNode prev, ListNode curr, int k){
        for(int i = 0; i < k - 1; i++){
            ListNode n = curr.next;
            curr.next = n.next;
            n.next = prev.next;
            prev.next = n;
        }
        return curr;
    }
}
