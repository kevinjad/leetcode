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
        ListNode head = new ListNode();
        ListNode iter = head;
        int carry = 0;
        while(l1 != null && l2 != null){
            int temp = l1.val + l2.val+carry;
            carry = temp/10;
            temp = temp%10;
            //create node and add to head
            ListNode node = new ListNode(temp);
            iter.next = node;
            iter = iter.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int temp = l1.val+carry;
            carry = temp/10;
            temp = temp%10;
            //create node and add to head
            ListNode node = new ListNode(temp);
            iter.next = node;
            iter = iter.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int temp = l2.val+carry;
            carry = temp/10;
            temp = temp%10;
            //create node and add to head
            ListNode node = new ListNode(temp);
            iter.next = node;
            iter = iter.next;
            l2 = l2.next;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            iter.next = node;
            iter = iter.next;
        }
        return head.next;
    }
}