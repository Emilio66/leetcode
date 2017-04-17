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
    //WATCH OUT: 
    //1. the left subtree's right subtree's value might greater than root's value
    //2. extreme case: [-2147483648,null,2147483647]
    //DFS, 1ms, beat 40%
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null) return true;
    //     return dfs(root.left, Long.MIN_VALUE, root.val)
    //         && dfs(root.right, root.val, Long.MAX_VALUE);
    // }
    //concise one
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean dfs(TreeNode node, long min, long max){
        if(node == null) return true;
        return node.val < max && node.val > min
            && dfs(node.left, min, node.val)
            && dfs(node.right, node.val, max);
    }
}
