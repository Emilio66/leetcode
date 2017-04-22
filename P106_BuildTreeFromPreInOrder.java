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
    //DFS version, beats 30%
    /*public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder.length != preorder.length)
            return null;
        
        return _buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode _buildTree(int[] pre, int pStart, int pEnd, int[] in, int iStart, int iEnd){
        if(pEnd < pStart) return null;
        if(pStart == pEnd) return new TreeNode(pre[pEnd]);
        
        TreeNode root = new TreeNode(pre[pStart]);
        int i = iStart;
        while(i < pEnd){
            if(in[i] == pre[pStart]) break;
            i++;
        }
        
        root.left = _buildTree(pre, pStart+1, pStart+i-iStart, in, iStart, i-1);
        root.right= _buildTree(pre, pStart+i-iStart+1, pEnd, in, i+1, iEnd);
        return root;
    }*/
    
    //iterative one, beats 88%, 5ms
    /* 1. traverse preorder array & build left subtree until root node meet in inorder
       2. keep pushing until no root node then
       3. build the right subtree
       */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder.length != preorder.length)  return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        //mark root position in inorder
        int pos = 0;
        for(int i = 1; i < preorder.length; i++){
            TreeNode node = stack.peek();
            if(inorder[pos] != stack.peek().val){
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            }else{
                //reach the most left node in this subtree
                while(!stack.empty() && inorder[pos] == stack.peek().val){
                    node = stack.pop();
                    pos++;
                }
                //build right subtree when subroot has been visited
                if(pos < inorder.length){
                    node.right = new TreeNode(preorder[i]);
                    stack.push(node.right);
                }
            }
        }
        
        return root;
    }
}
