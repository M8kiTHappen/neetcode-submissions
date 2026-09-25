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
    int runningSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        currentMax(root);
        return runningSum;
    }

    private int currentMax(TreeNode node){

        if(node == null){return 0;}

        int leftC = currentMax(node.left);
        if(leftC <= 0){
            leftC = 0;
        }
        int rightC = currentMax(node.right);
        if(rightC <= 0){
            rightC = 0;
        }

        runningSum = Math.max(runningSum, node.val + leftC + rightC);
        int otherSum = node.val + Math.max(leftC, rightC);
        return otherSum;
        
        
    }
}
