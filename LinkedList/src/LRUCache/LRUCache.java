package LRUCache;

import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int val;
    Node pre;
    Node next;
    public Node(int key,int val){
        this.val = val;
        this.key = key;
    }
}
class LRUCache {

    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.map = new HashMap<>();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            Node temp = getNode(key);
            putAtHeadNext(temp);
            return temp.val;
        }
    }


    public Node getNode(int key){
        Node temp = map.get(key);
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
        return temp;
    }

    public void put(int key, int value) {
        Node newNode =  new Node (key,value);

        if(map.containsKey(key)){
            Node temp = getNode(key);
            temp.val = value;
            putAtHeadNext(temp);
        }
        else{
            if(map.size() == capacity){
                removeTailPreNode();
            }
            putAtHeadNext(newNode);
            map.put(newNode.key,newNode);
        }
    }

    public void removeTailPreNode(){
        Node temp = tail.pre;
        temp.pre.next = tail;
        tail.pre = temp.pre;
        map.remove(temp.key);
    }

    public void putAtHeadNext(Node node){
        Node temp = head.next;
        head.next = node;
        node.pre = head;
        node.next = temp;
        temp.pre = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */