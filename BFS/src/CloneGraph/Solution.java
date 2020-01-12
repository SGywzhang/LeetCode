package CloneGraph;


import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

public class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node, newNode);
        queue.offer(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            for(Node nei : temp.neighbors){
                if(!map.containsKey(nei)){
                    map.put(nei, new Node(nei.val, new ArrayList<Node>()));
                    queue.offer(nei);
                }
                map.get(temp).neighbors.add(map.get(nei));
            }
        }
        return newNode;
    }
}
