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


//The second idea is more expensive, but it is better when the "processsing" is compilicated.
//The idea of using stack:
//Push nodes into a stack means the nodes are waiting to be processed, becasue we firstly process the left child and then process the node itself.
//Popping a node means we process the node.
//If then stack is empty, then it means all nodes have been processed.

class Solution{
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        List<Integer> res = new LinkedList<>();
        while(!nodes.isEmpty() || root != null){
            while(root != null){
            nodes.push(root);
            root = root.left;
            }
            root = nodes.pop();//pop a node which should be processed now becuase its left child is null.
            res.add(root.val);//process the node
            root = root.right;
            //After processing the node itself, we need to process the right child of the node.
            //If right child is null, then we know the right child has been processed.
            //At this momoment, left,middel and right are all processed, so root = stack.pop(),we process the parent node that are waiting in the stack.
            
        }
        return res;
        
    } 
}


