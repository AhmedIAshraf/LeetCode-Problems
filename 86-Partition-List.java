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
    public ListNode partition(ListNode head, int x) {
        
        ListNode firstGreater = null;
        ListNode lastGreater = null;
        ListNode lastLess = null;
        ListNode newHead = null;
        ListNode iterator = head;

        while (iterator != null){
            if (iterator.val >= x){
                if (firstGreater == null)
                    firstGreater = iterator;
                if (lastGreater != null)
                    lastGreater.next = iterator;
                lastGreater = iterator;
            }
            else{
                if (newHead == null)
                    newHead = iterator;
                if (lastLess != null)
                    lastLess.next = iterator;
                lastLess = iterator;
            }
            iterator = iterator.next;
        }


        if (lastLess != null)
            lastLess.next = firstGreater;
        if (lastGreater != null)
            lastGreater.next = null;

        return newHead == null ? head : newHead;
    }
}