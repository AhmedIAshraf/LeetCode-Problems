import java.util.Hashtable;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Hashtable<ListNode, Boolean> table = new Hashtable<>();
        ListNode tempA = headA;
        while(tempA != null){
            table.put(tempA, true);
            tempA = tempA.next;
        }

        ListNode returned = null;
        ListNode tempB = headB;
        while(tempB != null){
            if (table.containsKey(tempB)){
                if (returned == null)
                returned = tempB;
            }
            else{
                returned = null;
            }
            tempB = tempB.next;
        }
        return returned;
    }
}