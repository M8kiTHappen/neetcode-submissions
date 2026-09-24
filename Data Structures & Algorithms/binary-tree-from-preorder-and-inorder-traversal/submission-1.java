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
    HashMap<Integer, Integer> map = new HashMap<>();
    int preOrderIndex = 0;
    private int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int inLeft, int inRight){
        if(inLeft > inRight){
            return null;
        }

        int rootVal = preorder[preOrderIndex];
        preOrderIndex++;
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        root.left = build(inLeft, mid -1);
        root.right = build(mid + 1, inRight);

        return root;

        
    }
}
