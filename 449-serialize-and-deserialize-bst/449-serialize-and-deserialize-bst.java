/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> lst = new ArrayList<>();
        utilS(root, lst);
        String s = String.join(",", lst);
        //System.out.println(" sl :" + s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       String[] str = data.split(",");
       int idx[] = new int[]{0};
       return utilD(str, idx);
    }
    
    public void utilS(TreeNode root, List<String> lst)
    {
        if(root == null)
        { 
            lst.add("null");
            return;
        }
        
        lst.add(Integer.toString(root.val));
        
        utilS(root.left, lst);
        utilS(root.right, lst);
    }
    
    public TreeNode utilD(String[] str, int[] idx)
    {
       if(idx[0] == str.length)
           return null;
        
        if("null".equals(str[idx[0]]))
        {
            idx[0]++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(str[idx[0]++]));
        root.left = utilD(str, idx);
        root.right = utilD(str, idx);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;