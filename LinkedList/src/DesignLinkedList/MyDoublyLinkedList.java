package DesignLinkedList;

class MyDoublyLinkedList {

    class Node{
        Node next;
        Node pre;
        int val;
        public Node(int val){
            this.val = val;
        }
    }
    Node head;
    int size;
    /** Initialize your data structure here. */
    public MyDoublyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index <0 || index >=size) return -1;
        return getNode(index).val;
    }

    public Node getNode (int index){
        if(index == 0) return head;
        Node temp = head;
        while(temp.next!=null && index>0){
            temp = temp.next;
            index--;
        }
        return temp;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head == null){
            head = new Node(val);
            size++;
            return;
        }
        Node temp = new Node(val);
        temp.next = head;
        head.pre = temp;
        head = temp;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head ==null){
            head = new Node(val);
            size++;
            return;
        }
        Node tailNode = getTailNode();
        Node newNode = new Node(val);
        tailNode.next = newNode;
        newNode.pre = tailNode;
        size++;
    }

    public Node getTailNode(){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        return temp;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;

        if(index == 0){
            addAtHead(val);
        }
        else if (index == size){
            addAtTail(val);
        }
        else{
            Node temp = getNode(index);
            Node newNode = new Node(val);
            newNode.next = temp;
            newNode.pre = temp.pre;
            temp.pre.next = newNode;
            temp.pre = newNode;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;

        if(index==0){
            head = head.next;
            size--;
            return;
        }
        Node temp = getNode(index);
        temp.pre.next = temp.next;
        if(temp.next!=null) {
            temp.next.pre = temp.pre;
        }
        size--;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */