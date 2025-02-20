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
    public ListNode swapPairs(ListNode head) {
        
        ListNode prev = head;
        ListNode curr = (head == null) ? null : head.next;
        ListNode prevPair = null;

        while(curr != null){
            prev.next = curr.next;
            curr.next = prev;
            if (prevPair != null){
                prevPair.next = curr;
            }
            else{
                head = curr;
            }

            prevPair = prev;
            prev = prev.next;
            curr = (prev == null) ? null : prev.next;
        }

        return head;
    }
}