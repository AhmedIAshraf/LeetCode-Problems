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
        
        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode pre = new ListNode(0);
        ListNode p = pre; 

        while (p1 != null && p2 != null){
            int sum = p1.val + p2.val + carry;
            p.next = new ListNode (sum%10);
            carry = sum/10;

            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        while(p1 != null){
            p.next = new ListNode ((p1.val+carry)%10);
            carry = (p1.val+carry)/10;
            p = p.next;
            p1 = p1.next;
        }

        while(p2 != null){
            p.next = new ListNode ((p2.val+carry)%10);
            carry = (p2.val+carry)/10;
            p = p.next;
            p2 = p2.next;
        }

        if (carry > 0){
            p.next = new ListNode(carry);
        }
        return pre.next;
    }
}