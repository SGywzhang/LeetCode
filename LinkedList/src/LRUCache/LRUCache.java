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
public class LRUCache {

    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map;
    boolean flag;

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
            Node temp = map.get(key);
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
            putAtHeadNext(temp,false);
            return temp.val;
        }
    }

    public void put(int key, int value) {
        Node newNode =  new Node (key,value);

        if(map.containsKey(key)){
            Node temp = map.get(key);
            temp.val = value;
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
            putAtHeadNext(temp,false);
        }
        else{
            if(map.size() == capacity){
                removeTailPreNode();
            }
            putAtHeadNext(newNode,true);
        }
    }

    public void removeTailPreNode(){
        Node temp = tail.pre;
        temp.pre.next = tail;
        tail.pre = temp.pre;
        map.remove(temp.key);
    }

    public void putAtHeadNext(Node node, boolean flag){
        Node temp = head.next;
        head.next = node;
        node.pre = head;
        node.next = temp;
        temp.pre = node;
        if(flag){
            map.put(node.key,node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */