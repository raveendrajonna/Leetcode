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
        HashMap<String, Integer> hm = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        preOrder(root, hm, res);
        return res;
    }
    
    public String preOrder(TreeNode root, HashMap<String,Integer> hm , List<TreeNode> res)
    {
        if(root == null)
            return "null" ;
        

        String cur = root.val + "@" +preOrder(root.left, hm, res) +"@" +preOrder(root.right,hm,res);
        
         hm.put(cur, hm.getOrDefault(cur,0)+1);
         if(hm.get(cur) == 2)
         {
             res.add(root);
         } 
        return cur;
    }
}