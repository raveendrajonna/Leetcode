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
        getLevel(root, res);
        return res;
    }
    
    public int getLevel(TreeNode root, List<List<Integer>> res)
    {
        if(root == null)
            return 0;
        
        int l = getLevel(root.left, res);
        int r = getLevel(root.right, res);
        int level = Math.max(l,r);
        if(res.size() <= level)
        {
            res.add( new ArrayList<>());
        }
        res.get(level).add(root.val);
        return level+1;
    }
}