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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head : lists){
            if(head!=null){
                pq.add(head);
            }
            
        }
        ListNode dup = new ListNode(-1);
        ListNode t1 = dup;
        while(pq.size()!=0){
            ListNode temp = pq.poll();
            t1.next = temp;
            if(temp.next!=null){
                pq.add(temp.next);
            }
            t1 = t1.next;
            
        }
        return dup.next;
        
    }
}