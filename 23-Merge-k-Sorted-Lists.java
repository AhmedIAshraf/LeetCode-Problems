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
        if (lists.length == 0){
            return null;
        }
        return mergeSort(lists, 0, lists.length-1);
    }
    
    public ListNode mergeSort(ListNode[] lists, int l, int r){
        
        if (r == l){
            return lists[r];
        }
        if (r-l == 1){
            return merge(lists[l], lists[r]);
        }

        int m = (r+l)/2;
        ListNode left = mergeSort(lists, l, m);
        ListNode right = mergeSort(lists, m+1, r);

        return merge(left, right);
    }

    public ListNode merge(ListNode a, ListNode b){
        
        if (a == null)
            return b;
        if (b == null)
            return a;

        ListNode pa = a;
        ListNode pb = b;
        ListNode c, merged;

        if (pa.val <= pb.val){
            c = new ListNode(pa.val);
            pa = pa.next;
        }
        else{
            c = new ListNode(pb.val);
            pb = pb.next;
        }
        merged = c;

        while(pa != null && pb != null){
            if (pa.val <= pb.val){
                c.next = new ListNode(pa.val, null);
                pa = pa.next;
            }
            else{
                c.next = new ListNode(pb.val, null);
                pb = pb.next;
            }
            c = c.next;
        }

        while(pa != null){
            c.next = new ListNode(pa.val, null);
            pa = pa.next;
            c = c.next;
        }
        while(pb != null){
            c.next = new ListNode(pb.val, null);
            pb = pb.next;
            c = c.next;
        }

        return merged;
    }
}