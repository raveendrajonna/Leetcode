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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer> hm  = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        postOrder(root,hm, res);
        return res;
    }
    
    public String postOrder(TreeNode root, HashMap<String,Integer> hm, List<TreeNode> res)
    {
        if(root == null)
             return "#";
        
        String key = root.val+","+postOrder(root.left,hm, res)+","+postOrder(root.right, hm, res);
        hm.put(key, hm.getOrDefault(key,0)+1);
        if(hm.get(key)==2)
        {
            res.add(root);      
        }
        return key;
    }
}