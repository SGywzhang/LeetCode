package DesignHashSet;

class Node{
    int hash;
    int key;
    Node next;
}

class MyHashSet {
    Node[] table;
    int length = 100000;
    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new Node[length];
    }

    int getHashVal(int key){
        return key % length;
    }

    public void add(int key) {
        Node newNode = new Node();
        newNode.hash = getHashVal(key);
        newNode.key = key;

        if(table[newNode.hash] == null){
            table[newNode.hash] = newNode;
        }
        else{
            Node temp = table[newNode.hash];
            while(temp!=null){
                if(temp.key == newNode.key){
                    return;
                }
                else{
                    temp = temp.next;
                }
            }
            temp.next = newNode;
        }
    }

    public void remove(int key) {
        int hashVal = getHashVal(key);
        if(table[hashVal] == null){
            return;
        }
        Node temp = table[hashVal];
        while(temp != null){
            if(temp.key == key){
                if(temp.next == null){
                    table[hashVal] = null;
                }
                else{
                    temp.hash = temp.next.hash;
                    temp.key = temp.next.key;
                    temp.next = temp.next.next;
                }
            }
            temp = temp.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashVal = getHashVal(key);
        if(table[hashVal] == null){
            return false;
        }
        Node temp = table[hashVal];
        while(temp != null){
            if(temp.key == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */