public class Solution {
    
    //my recursive version, beats 6.3%
    /*public List<String> generateParenthesis(int n) {
        if(n == 0)
            return new ArrayList<String>();
            
        if(n == 1){
            List<String> results = new ArrayList<String>();
            results.add("()");
            return results;
        }
        
        List<String> subResult  = generateParenthesis(n - 1);
        
        int size = subResult.size();
        if(size == 0){
            List<String> results = new ArrayList<String>();
            results.add("()");
            return results;
        }
        
        Set<String> resultSet    = new HashSet<String>();
        for(int i = 0; i < size; i++){
            String temp = subResult.get(i);
            resultSet.add("()" + temp);
            for(int j = 1; j < temp.length(); j ++){
                resultSet.add(temp.substring(0, j) + "()" + temp.substring(j));              
            }
        }
        
        List<String> results = new ArrayList<String>();
        results.addAll(resultSet);
        
        return results;
    }*/
    
    //iterative version, beats 8.6%, O(n^3)
    /*public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<String>();
        
        if(n == 0)
            return results;
        
        Set<String> hashSet    = new HashSet<String>();
        results.add("()");
        
        for(int i = 2; i <= n; i++){
            List<String> newResults = new ArrayList<String>();
            
            for(int j = 0; j < results.size(); j++){
                String temp = results.get(j);
                
                //place "()" in any possible position in previous string
                for(int k = 0; k < temp.length(); k ++){
                    String str = temp.substring(0, k) + "()" + temp.substring(k);
                    
                    if(hashSet.add(str)){
                        newResults.add(str);
                    }
                }
            }
            
            results = newResults;
        }
        
        return results;
    }*/
    
    //BFS version, tree structure, match among leaf nodes, O(n^2), beats 11.6%
    /*class Node{
        String str; //parenthesis string in this node
        int leftN;  //left parenthesis number

        public Node(String str, int N){
            this.str = str;
            this.leftN = N;
        }
    }

    //generates the leaf nodes
    public Node[] leafNodes(int n){
        LinkedList<Node> queue = new LinkedList<Node>();

        Node root = new Node("", 0);
        queue.addLast(root);
        long num = 2 << (n - 1); //n > 1

        while(queue.size() < num){
            Node node = queue.removeFirst();
            queue.addLast(new Node(node.str + "(", node.leftN++));  //left node
            queue.addLast(new Node(node.str + ")", node.leftN));    //right node
        }

        Node[] nodes = new Node[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            nodes[i] = queue.get(i);
        }

        return nodes;
    }

    //judge whether a parenthesis is well-formed
    public boolean isLegalParenthesis(String parenthesis){
        if(parenthesis.length() == 0 ||parenthesis.charAt(0) == ')')
            return false;

        int match = 1;
        for(int i = 1; i < parenthesis.length(); i++){
            if(match < 0)
                break;
            if(parenthesis.charAt(i) == '(')
                match++;
            else
                match--;
        }

        return match == 0;
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<String>();
        if(n == 0)
            return results;
        if(n == 1){
            results.add("()");
            return results;
        }

        Node[] leaves = leafNodes(n);

        //let the left part match with the right part
        //NOTE: All the node in the right subtree that ends with "(" are not qualified
        int len = leaves.length;
        int middle = len / 2 - 1;

        results.add(leaves[0].str + leaves[len - 1].str);

        for (int i = 1; i <= middle; i++) {
            Node left = leaves[i];
            int complement = n - left.leftN;

            for (int j = len - 2; j > 0; j--) {
                if (leaves[j].leftN == complement){
                    String parenthesis = left.str + leaves[j].str;

                    if(isLegalParenthesis(parenthesis))
                        results.add(parenthesis);
                }
            }
        }

        return results;
    }*/
    
    //////////////////////////////////////////////
    //DFS version, tree structure, beats 16.8 %
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        DFS(result, "", n, 0, 0);
        
        return result;
    }
    
    private void DFS(List<String> result, String parenthesis, int n, int left, int right){
        if(left == n && right == n)
            result.add(parenthesis);
            
        if(right > left || left > n || right > n)
            return;
        
        DFS(result, parenthesis + "(", n, left + 1, right);
        DFS(result, parenthesis + ")", n, left, right + 1);
        
    }
}
