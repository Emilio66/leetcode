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
    /*
    //recursive version, beats 3.6%
    public int minDepth(TreeNode root) {
        if(null == root)
            return 0;
        if(null == root.left)
            return 1 + minDepth(root.right);
        if(null == root.right)
            return 1 + minDepth(root.left);
        
        return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }*/
    
    //BFS version 1, beats 16.3%
    /*public int minDepth(TreeNode root) {
        if(null == root)
            return 0;
        if(null == root.left && null == root.right)
            return 1;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node;
        //root node, depth = 0, node number = 1
        int depth = 0;
        queue.addLast(root);
        
        while(!queue.isEmpty()){
            //level by level, queue contains 1 level's node
            int childN = queue.size();
            for(int i = 0; i < childN; i++){
                node = queue.removeFirst();
                //find leaf node
                if(null == node.left && null == node.right)
                    return depth + 1;   
                    
                if(node.left != null)
                    queue.addLast(node.left);
                if(node.right != null)
                    queue.addLast(node.right);
            }
                
            depth++;
        }
        
        return depth;
    }*/
    
    /*//BFS versinon 2, use array instead of queue, beats 16.4%
    public int minDepth(TreeNode root) {
        if(null == root)
            return 0;
        if(null == root.left && null == root.right)
            return 1;
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode node;
        //root node, depth = 0, node number = 1
        int depth = 0, index = 0, childN = 1;
        list.add(root);
        
        while(true){
            //level by level, queue contains 1 level's node
            int temp = 0;
            for(int i = 0; i < childN; i++){
                node = list.get(index + i);
                //find leaf node
                if(null == node.left && null == node.right)
                    return depth + 1;   
                    
                if(node.left != null){
                    list.add(node.left);
                    temp++;
                }
                if(node.right != null){
                    list.add(node.right);
                    temp++;
                }
            }
            
            index += childN; //slide window
            childN = temp;
            depth++;
        }
    }*/
    
    //BFS versinon 3, use 2 array, beats 16.4%; no need to traverse all the node
    public int minDepth(TreeNode root) {
        if(null == root)
            return 0;
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        List<TreeNode> nextLevel;
        TreeNode node;
        //root node, depth = 0, node number = 1
        int depth = 0;
        list.add(root);
        
        while(true){
            //level by level, queue contains 1 level's node
            nextLevel = new ArrayList<TreeNode>();
            for(int i = 0; i < list.size(); i++){
                node = list.get(i);
                //find leaf node
                if(null == node.left && null == node.right)
                    return depth + 1;   
                    
                if(node.left != null){
                    nextLevel.add(node.left);
                }
                if(node.right != null){
                    nextLevel.add(node.right);
                }
            }
            list = nextLevel;
            depth++;
        }
    }
    //DFS version, combined with post order traverse
    /*public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        TreeNode node = root;
        TreeNode pre = null;
        int depth = Integer.MAX_VALUE;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while(node != null || !stack.isEmpty()){
            if (node != null){
                //leaf node, stack size indicates path length, find the shortest path
                if(node.left == null && node.right == null){
                    depth = (depth > stack.size() + 1) ? stack.size() + 1 : depth;
                }

                stack.push(node);
                node = node.left;

            }else{
                node = stack.poll();
                if (node.right != null && node.right != pre) {
                    stack.push(node);
                    node = node.right;
                }
                else{
                    pre = node;
                    node = null;
                }

            }
        }

        return depth;
        
    }*/
    }
