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
    int in=0;
    int pre=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return util(preorder,inorder,Integer.MIN_VALUE);
        //Order of O(n) solution.
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
        
        int val = preorder[pre++];
        TreeNode root = new TreeNode(val);
        root.left = util(preorder,inorder,val);
        root.right = util(preorder,inorder,stop);
        return root;
    }
}
