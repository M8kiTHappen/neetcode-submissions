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
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.val, b.val)
        );

        for(ListNode list : lists){
            if(list != null){
                pq.add(list);
            }
        }
        ListNode result = null;
        ListNode resultEnd = null;
        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            if(result == null){
                result = smallest;
            } else {
                resultEnd.next = smallest;
            }
            resultEnd = smallest;
            if(smallest.next != null){
                pq.add(smallest.next);
            }
        }

        return result;
        
    }
}
