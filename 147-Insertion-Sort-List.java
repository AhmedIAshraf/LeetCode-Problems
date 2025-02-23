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
    public ListNode insertionSortList(ListNode head) {
        
        ListNode prev = head;
        ListNode iterator = prev.next;
        
        while(iterator != null){
            if (iterator.val < prev.val){
                ListNode p = head;
                ListNode preSorted = null;
                
                while (iterator.val > p.val){
                    preSorted = p;
                    p = p.next;
                }

                prev.next = iterator.next;
                iterator.next = p;
                if (preSorted != null){
                    preSorted.next = iterator;
                }
                else{
                    head = iterator;
                }

                prev = p;
                iterator = p.next;
            }
            else{
                prev = iterator;
                iterator = iterator.next;
            }
        }

        return head;
    }
}