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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode temp = head;
        ListNode tempDelayed = head;
        while(temp != null){
            temp = temp.next;
            if(i>n){
                tempDelayed = tempDelayed.next;
            }
            i++;
        }
        if(tempDelayed == head && i==n) return head.next;
        if(tempDelayed != null && tempDelayed.next != null) tempDelayed.next = tempDelayed.next.next;
         
        return head;
    }
}