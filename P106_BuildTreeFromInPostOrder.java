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
    /**
     * @Author Z.Y.Zhao
     * 1. poster order sequence decides the root
     * 2. inorder sequence is responsible for splitting the sequence to left subtree & right subtree according to step1
     * 3. go to step 1 until all work done
     *
     **/
    /*public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || inorder.length != postorder.length)
            return null;
        if(inorder.length == 1)
            return new TreeNode(inorder[0]);
            
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        
        //no right subtree, the same sequence
        if(Arrays.equals(inorder, postorder)){
            TreeNode node = root;
            for(int i = inorder.length - 2; i >= 0; i--){
                node.left = new TreeNode(inorder[i]);
                node = node.left;
            }
            return root;
        }
        
        //build right subtree, use the remained to build left subtree
        int rootPos = find(rootVal, inorder, 0, inorder.length-1);
        int[] leftInorder = null;
        if(rootPos > 0){
            leftInorder = new int[rootPos];
            System.arraycopy(inorder, 0, leftInorder, 0, rootPos);
        }
        int[] rightInorder = null;
        if(rootPos < inorder.length - 1){
            rightInorder = new int[inorder.length - rootPos - 1];
            System.arraycopy(inorder, rootPos + 1, rightInorder, 0, inorder.length-1);
        }
        
        int[] leftPostorder = null;
        if(leftInorder != null){
            leftPostorder = new int[leftInorder.length];
            System.arraycopy(postorder, 0, leftPostorder, 0, leftPostorder.length);
        }
        
        int len = leftPostorder == null ? 0 : leftPostorder.length;
        
        int[] rightPostorder = null;
        if(len > 0){
            rightPostorder = new int[rightInorder.length];
            System.arraycopy(postorder, len, rightPostorder, 0, rightPostorder.length);
        }
        
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        
        return root;
    }*/
    
    public int find(int x, int[] data, int start, int end){
        if(end > start)
            for(int i = start; i < end; i++)
                if(data[i] == x) return i;
        return -1;
    }
    
    private TreeNode _buildTree(int[] inorder, int iBegin, int iEnd, int[] postorder, int pBegin, int pEnd){
        if(iBegin < iEnd) return null;
        if(iBegin == iEnd) return new TreeNode(inorder[iEnd]);
        int rootVal = postorder[pEnd];
        int pos = find(rootVal, inorder, iBegin, iEnd);
        
        TreeNode root = new TreeNode(rootVal);
        root.left = _buildTree(inorder, iBegin, pos-1, postorder, pBegin, pos-1);
        root.right= _buildTree(inorder, pos+1, iEnd, postorder, pos, pEnd-1);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || inorder.length != postorder.length) return null;
        if(inorder.length == 1) return new TreeNode(inorder[0]);
        
        return _buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
}
