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
    public int goodNodes(TreeNode root) {
        return countGood(root, Integer.MIN_VALUE);
    }

    private int countGood(TreeNode node, int maxSoFar){
        if(node == null){return 0;}

        int count = 0;
        int newMax;
        if(node.val >= maxSoFar){
            count = 1;
            newMax = node.val;
        } else{
            newMax = maxSoFar;
        }

        count += countGood(node.left, newMax);
        count += countGood(node.right, newMax);

        return count;
    }
}
