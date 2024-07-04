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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next;
        int sum = 0;
        ListNode ans = new ListNode(-1);
        ListNode dum = ans;
        while(temp!=null){
            sum+=(temp.val);
            if(temp.val==0){
                ListNode nn = new ListNode(sum);
                ans.next = nn;
                ans = ans.next;
                sum=0;
            }
            temp = temp.next;
            
        }

        return dum.next;
    }
}