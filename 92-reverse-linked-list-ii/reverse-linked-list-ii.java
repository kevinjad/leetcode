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
        if(left == right) return head;
        ListNode n = head;
        ListNode firstPrev = null;
        for(int i = 1;i<left;i++){
            firstPrev = n;
            n = n.next;
        }
        // now n is left's reference
        ListNode nn = n.next;
        ListNode prev = n;
        for(int i = left;i<right;i++){
            ListNode nxt = nn.next;
            nn.next = prev;
            prev = nn;
            nn = nxt;
        }
        n.next = nn;
        if(firstPrev == null){
            return prev;
        }
        firstPrev.next=prev;
        return head;
    }
}