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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1==null){
            return list2;
        }
        else if (list2==null){
            return list1;
        }

        ListNode head = null, p = null;
        ListNode i = list1;
        ListNode j = list2;

        while(i != null && j != null){
            if (i.val <= j.val){
                if (head == null){
                    head = new ListNode(i.val);
                    p = head;
                }
                else{
                    p.next = new ListNode(i.val);
                    p = p.next;
                }
                i = i.next;
            }
            else{
                if (head == null){
                    head = new ListNode(j.val);
                    p = head;
                }
                else{
                    p.next = new ListNode(j.val);
                    p = p.next;
                }
                j = j.next;
            }
        }

        while(i != null){
            p.next = new ListNode(i.val);
            i = i.next;
            p = p.next;
        }
        while(j != null){
            p.next = new ListNode(j.val);
            j = j.next;
            p = p.next;
        }

        return head;
    }
}