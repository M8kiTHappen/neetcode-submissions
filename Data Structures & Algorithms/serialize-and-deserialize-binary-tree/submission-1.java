/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    
    LinkedList<String> result = new LinkedList<>();
    private void preorder(TreeNode node){
        if (node == null){
            result.add("null");
            return;
        }
        result.add(Integer.toString(node.val));
        preorder(node.left);
        preorder(node.right);
    }
    private TreeNode build(Queue<String> q){
        String val = q.poll();
        if(val.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = build(q);
        node.right = build(q);
        return node;
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        result.clear();
        preorder(root);
        
        return String.join("#", result);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split("#");
        Queue<String> q = new LinkedList<>(Arrays.asList(tokens));
        return build(q);
    }
}
