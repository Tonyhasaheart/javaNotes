/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //To sum up, search left, add middle and search right. We only add "middle" point.
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        return helper(root,res);
    }
    
    public List<Integer> helper(TreeNode root, List<Integer> res){
        if(root != null){
            if(root.left != null){
                helper(root.left,res);
            }
            res.add(root.val);
           // This is the only "add" operation.
            if(root.right != null)
                helper(root.right,res);
        }
        return res;
    }
}
