package DesignHashMap;

class Node{
    int hash;
    int key;
    int val;
    Node next;
}

class MyHashMap {
    Node[] table;
    int length;
    /** Initialize your data structure here. */
    public MyHashMap() {
        length = 100000;
        table = new Node[length];

    }
    int getHashValue(int key){
        return (key % length);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node newNode = new Node();
        newNode.hash = getHashValue(key);
        newNode.key = key;
        newNode.val =value;
        newNode.next = null;
        Node temp = table[newNode.hash];

        if(temp == null){
            table[newNode.hash] = newNode;
        }
        else{
            while(temp!=null){
                if(temp.key == newNode.key){
                    temp.val = newNode.val;
                    return;
                }
                else{
                    temp = temp.next;
                }
            }
            temp.next = newNode;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashVal = getHashValue(key);
        if(table[hashVal] == null){
            return -1;
        }
        Node temp = table[hashVal];

        while(temp != null){
            if(temp.key == key){
                return temp.val;
            }else{
                temp = temp.next;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashVal = getHashValue(key);
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
                    temp.val = temp.next.val;
                    temp.next = temp.next.next;
                }
                return;
            }
            temp = temp.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
