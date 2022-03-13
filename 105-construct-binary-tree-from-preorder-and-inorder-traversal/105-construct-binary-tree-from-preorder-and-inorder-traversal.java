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
    int in;
    int pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return util(preorder, inorder, Integer.MAX_VALUE);
    }
    
    public TreeNode util(int[] preorder, int[] inorder, int stop)
    {
        if(pre == preorder.length)
            return null;
        
        if(inorder[in] == stop)
        {
            in++;
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pre++]);
        root.left = util(preorder, inorder, root.val);
        root.right = util(preorder, inorder, stop);
        return root;
    }
}