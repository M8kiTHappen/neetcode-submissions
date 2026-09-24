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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValid(TreeNode node, int lower, int higher) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= higher) {
            return false;
        }

        return isValid(node.left, lower, node.val) && isValid(node.right, node.val, higher);
    }
}
