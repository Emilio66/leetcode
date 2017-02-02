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
    //recursive version, beats 90.49%, good for small data set
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null)
            return maxDepth(root.right) + 1;
        if(root.right == null)
            return maxDepth(root.left) + 1;
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
    /*
    //BFS version, using level-order traversal, beats 4.8%, space cost 
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        int depth = 0, childN;
        while(queue.isEmpty() == false){
            childN = queue.size();
            for(int i = 0; i < childN; i++){
                root = queue.removeFirst();
                if(root.left != null)
                    queue.addLast(root.left);
                if(root.right != null)
                    queue.addLast(root.right);
            }
            depth ++;
        }
        
        return depth;
    }*/
}
