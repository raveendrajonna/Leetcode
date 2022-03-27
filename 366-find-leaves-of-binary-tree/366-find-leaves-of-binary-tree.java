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
    public List<List<Integer>> findLeaves(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      getHeight(root, res);
        return res;
    }
    
    public int getHeight(TreeNode root, List<List<Integer>> res)
    {
        if(root == null)
            return 0;
        
        int l = getHeight(root.left,  res);
        int r = getHeight(root.right, res);
        int level = Math.max(l,r)+1;
        
        if(res.size() <level)
        {
            res.add(new ArrayList<Integer>());   
        }
         res.get(level-1).add(root.val);
        
        return level;
        
    }
}