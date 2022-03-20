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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLca(root,startValue, destValue);
        
        List<String> lstr = new ArrayList<>();
        getDirection(lca,startValue,lstr);
        
        List<String> rstr =new ArrayList<>();
        getDirection(lca, destValue, rstr);
        
        StringBuilder sb = new StringBuilder();
        for(String str : lstr)
            sb.append("U");
        
        for(String str : rstr)
        {
            sb.append(str);
        }
        
        return sb.toString();
        
    }
    
    public boolean getDirection(TreeNode root, int val, List<String> lst)
    {
        if(root == null) 
            return false;
        
        if(root.val == val)
            return true;
        
        lst.add("L");
        if(getDirection(root.left, val, lst))
        {
            return true;
        }
        lst.remove(lst.size()-1);
        
        lst.add("R");
        if(getDirection(root.right, val, lst))
        {
            return true;
        }
        lst.remove(lst.size()-1);
        
        return false;
    }
    
    public TreeNode findLca(TreeNode root, int startValue, int destValue)
    {
        if(root == null)
            return null;
        
        if(root.val == startValue || root.val == destValue)
            return root;
        
        TreeNode l = findLca(root.left, startValue, destValue);
        TreeNode r = findLca(root.right, startValue, destValue);
        
        if(l != null && r != null) 
            return root;
        else if(l!= null)
            return l;
        else 
            return r;
    }
}