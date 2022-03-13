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
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
       height (root);
        return ans;
    }
    
    public int height(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int l = height(root.left);
        int r = height(root.right);
        
        ans = Math.max(ans, Math.max(Math.max(l,r), l+r));
        
        return Math.max(l,r)+1;
    }
}