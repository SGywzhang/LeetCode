package CopyListWithRandomPointer;
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
//class Solution {
//    public Node copyRandomList(Node head) {
//        if(head == null) return null;
//        Node cur = head;
//        while(cur != null){
//            Node newNode = new Node(cur.val);
//            newNode.next = cur.next;
//            cur.next = newNode;
//            cur = cur.next.next;
//        }
//
//        cur = head;
//        while(cur != null){
//            if(cur.random != null){
//                cur.next.random = cur.random.next;
//            }
//            cur = cur.next.next;
//        }
//
//        Node dummy = new Node(-1);
//        cur = head;
//        Node temp = dummy;
//        while(cur != null){
//            temp.next = cur.next;
//            cur.next = cur.next.next;
//            temp = temp.next;
//            cur =cur.next;
//
//        }
//        return dummy.next;
//    }
//}
