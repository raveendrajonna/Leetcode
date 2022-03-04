/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       return util(root,subRoot,0);
    }
    
    public boolean util(TreeNode root, TreeNode subRoot,int level)
    {
        if(root==null && subRoot==null)
            return true;
        
        if(root==null && subRoot !=null || root != null && subRoot == null)
            return false;
        
        if(root.val == subRoot.val)
        {
            boolean val = (util(root.left, subRoot.left,level+1) && util(root.right, subRoot.right, level+1));
            if(val) return val;
        }
        
        if(level == 0)
        {
            return util(root.left,subRoot,level) || util(root.right, subRoot, level);
        }
        
        return false;
    }
}
