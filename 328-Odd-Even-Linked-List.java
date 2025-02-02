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
    public ListNode oddEvenList(ListNode head) {
        
        ListNode lastOdd = null;
        ListNode lastEven = null;
        ListNode firstEven = null;
        ListNode iterator = head;
        boolean even = false;

        while(iterator != null){
            if (even){
                if (lastEven != null){
                    lastEven.next = iterator;
                }
                if (firstEven == null){
                    firstEven = iterator;
                }
                lastEven = iterator;
            }
            else{
                if (lastOdd != null){
                    lastOdd.next = iterator;
                }
                lastOdd = iterator;
            }
            iterator = iterator.next;
            even = !even;
        }

        if (lastOdd != null)
            lastOdd.next = firstEven;
        if (lastEven != null)
            lastEven.next = null;
        return head;
    }
}