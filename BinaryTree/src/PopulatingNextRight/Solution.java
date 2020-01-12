package PopulatingNextRight;

import java.util.LinkedList;


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

//class Solution {
//    public Node connect(Node root) {
//        if(root == null) return null;
//        if(root.left != null) root.left.next = root.right;
//        if(root.right !=null) root.right.next = root.next != null ? root.next.left : null;
//        connect(root.left);
//        connect(root.right);
//        return root;
//    }
//}

class Solution {
    public Node connect(Node root) {

        if(root == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node cur = queue.removeFirst();
                if(i < size -1 ){
                    cur.next = queue.peek();
                }
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return root;
    }
}