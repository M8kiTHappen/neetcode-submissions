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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){ return List.of();}

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> result = new LinkedList<>();

        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> currentLevel = new LinkedList<>();

            for(int i = 0; i < levelSize; i++){
                TreeNode node = q.poll();
                currentLevel.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }

            result.add(currentLevel);



        } 

        return result;
    }
}
