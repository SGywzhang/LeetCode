package DesignLinkedList;

class MySingleLinkedList {

    /** Initialize your data structure here. */
    class Node{
        Node next;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private int size;
    public MySingleLinkedList() {
        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node temp = getNode(index);
        return temp.value;
    }

    public Node getNode(int index){
        if(index == 0) return head;
        Node temp = head;
        while(temp.next != null && index > 0){
            temp = temp.next;
            index--;
        }
        return temp;
    }


    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head == null){
            head = new Node(val);
            size ++;
            return;
        }
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        size ++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null){
            head = new Node(val);
            size ++;
            return;
        }
        Node tailNode = getTailNode();
        tailNode.next = new Node(val);
        size ++;
    }


    public Node getTailNode(){
        if(head == null) return null;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if (index > size) return;

        if(index == size){
            addAtTail(val);
            return;
        }
        else if(index == 0){
            addAtHead(val);
            return;
        }
        else{
            Node temp = getNode(index-1);
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            size ++;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;

        if(index == 0){
            head = head.next;
            size--;
            return;
        }
        Node temp = getNode(index -1);
        Node delNode = getNode(index);
        temp.next = delNode.next;
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