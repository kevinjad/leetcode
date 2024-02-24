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
        int totalLength = 0;
        ListNode temp = head;
        while(temp != null){
            totalLength++;
            temp = temp.next;
        }
        int firstN = totalLength-n;
        temp = head;
        System.out.println(firstN);
        int i = 0;
        if(firstN == 0 && totalLength == 1) return null;
        if(firstN == 0) return head.next;
        while(i < firstN-1){
            temp = temp.next;
            i++;
        }
        if(temp != null && temp.next != null) temp.next = temp.next.next;
        else temp = null;
        return head;
    }
}