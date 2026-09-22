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
    private int d;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterHelper(root);
        return d;
    }
    private int diameterHelper(TreeNode root){
        if(root == null){return 0;}

        int leftP = diameterHelper(root.left);
        int rightP = diameterHelper(root.right);

        d = Math.max(d, leftP + rightP);

        return Math.max(leftP, rightP) + 1;
    }
}
