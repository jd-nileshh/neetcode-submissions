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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        int i = 1;

        while(curr != null && i != left){
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode pointerToStart = prev;
        ListNode start = curr;
        prev = null;
        while(curr != null && i != right + 1){
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
            i++;
        }
        start.next = curr;
        if(pointerToStart != null){
            pointerToStart.next = prev;
        }else{
            return prev; // if left is index 0 then it will be new head
        }
        return head;
    }
}