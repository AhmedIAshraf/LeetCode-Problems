import java.util.Hashtable;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Hashtable <ListNode, Boolean> table = new Hashtable<>(); 
        while(head != null){
            if (table.containsKey(head)){
                return true;
            }
            table.put(head, true);
            head = head.next;
        }
        return false;
    }
}