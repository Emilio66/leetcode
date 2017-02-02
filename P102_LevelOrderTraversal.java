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
    //BFS 1, queue based, beats 39.08 %
    /*public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        
        if(root != null){
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            queue.addLast(root);
            List<Integer> list;
            int childN;     //record child number in every level
            
            while(!queue.isEmpty()){
                childN = queue.size(); //child number on the current level
                list = new ArrayList<Integer>();
                
                for(int i = 0; i < childN; i++){
                    root = queue.removeFirst();
                    list.add(root.val);
                    
                    if(root.left != null)
                        queue.addLast(root.left);
                    if(root.right != null)
                        queue.addLast(root.right);
                }
                
                resultList.add(list);
            }
        }
        
        return resultList;
    }*/
    
    //BFS 2, use two list
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(root != null){
            List<Integer> valueList = new ArrayList<Integer>();
            List<TreeNode> nodeList = new ArrayList<TreeNode>();
            List<TreeNode> nextLevel;
            TreeNode node;
            nodeList.add(root);
            
            while(nodeList.isEmpty() == false){
                //level by level, queue contains 1 level's node
                
                nextLevel = new ArrayList<TreeNode>();
                for(int i = 0; i < nodeList.size(); i++){
                    node = nodeList.get(i);
                    valueList.add(node.val);
                        
                    if(node.left != null){
                        nextLevel.add(node.left);
                    }
                    if(node.right != null){
                        nextLevel.add(node.right);
                    }
                }
                
                nodeList = nextLevel;
                resultList.add(valueList);
                
                valueList = new ArrayList<Integer>();
            }
        }
        
        return resultList;
    }
}
