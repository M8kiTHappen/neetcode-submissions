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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){return new LinkedList<>();}

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Integer> result = new LinkedList<>();

        while(!q.isEmpty()){
            int levelSize = q.size();
            
            for(int i = 0; i < levelSize; i++){
                TreeNode node = q.poll();
                
                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }

                if(i == levelSize - 1){
                    result.add(node.val);
                }
                
            }
            
        }

        return result;
    }
}
