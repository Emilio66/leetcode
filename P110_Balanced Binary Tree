/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int depth(TreeNode root){
        if(root == null)
            return 0;
        
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    
    //recursive version, beats 24.6%
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int leftH = depth(root.left);
        int rightH = depth(root.right);
        
        return (Math.abs(leftH - rightH) <= 1) && isBalanced(root.left) && isBalanced(root.right); //ensure all subnodes are balanced
    }
}
