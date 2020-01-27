package SerializeAndDeserializeBinaryTree;

import Node.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encodeHelper(root,sb);
        return sb.toString();
    }

    public void encodeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#");
            sb.append(",");
        }else{
            sb.append(String.valueOf(root.val));
            sb.append(",");
            encodeHelper(root.left, sb);
            encodeHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        String[] ss = data.split(",");
        Collections.addAll(queue,ss);
        return decodeHelper(queue);
    }

    public TreeNode decodeHelper(Queue<String>queue){
        String s = queue.poll();
        if(s.equals("#")) return null;
        TreeNode cur = new TreeNode(Integer.parseInt(s));
        cur.left = decodeHelper(queue);
        cur.right = decodeHelper(queue);
        return cur;
    }
}
