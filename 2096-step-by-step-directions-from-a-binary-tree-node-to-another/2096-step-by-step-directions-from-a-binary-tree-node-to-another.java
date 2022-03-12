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
        TreeNode lca = findLCA(root, startValue, destValue);
        
        List<Character> slst = new ArrayList<>();
        getDirection(lca, startValue, slst);
        
        List<Character> dlst = new ArrayList<>();
        getDirection(lca, destValue, dlst);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< slst.size(); i++)
            sb.append("U");
        
        for(int i=0; i<dlst.size(); i++)
            sb.append(dlst.get(i));
        
        return sb.toString();
    }
    
    public TreeNode findLCA(TreeNode root, int s, int d)
    {
        if(root == null) return null;
        if(root.val == s || root.val == d) return root;
        
        TreeNode l = findLCA(root.left, s, d);
        TreeNode r = findLCA(root.right, s, d);
        
        if(l != null && r != null) return root;
        if(l!= null) return l;
        return r;
    }
    
    public boolean getDirection(TreeNode root, int v, List<Character> lst)
    {
        if(root == null) return false;
        
        if(root.val == v) return true;
        
        lst.add('L');
        if ( getDirection(root.left, v, lst)) return true;
        lst.remove(lst.size()-1);
        
        lst.add('R');
        if(getDirection(root.right, v, lst)) return true;
        lst.remove(lst.size()-1);
        
        return false;
    }
}