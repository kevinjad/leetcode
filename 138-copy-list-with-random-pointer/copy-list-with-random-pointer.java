/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node newHead = new Node(0);
        int i = 0;
        Node temp = newHead;
        Node orgtemp = head;
        while(orgtemp != null){
            Node n = new Node(orgtemp.val);
            map.put(orgtemp, n);
            temp.next = n;
            temp = temp.next;
            orgtemp = orgtemp.next;
        }

        orgtemp = head;
        temp = newHead;
        while(orgtemp != null){
            if(orgtemp.random != null){
                Node newRand = map.get(orgtemp.random);
                temp.next.random = newRand;
            }
            orgtemp = orgtemp.next;
            temp = temp.next;
        }
        return newHead.next;
    }
}