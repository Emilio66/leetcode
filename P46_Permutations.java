public class Solution {
    
    //n! recursion, remove one, append one, beats 10% 
    //copy list takes time
/*    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>(); //type variable must be the same, or use diamond operator <> to let the compiler inference the type automatically
        if(nums == null || nums.length == 0){
            results.add(new ArrayList<Integer>()); //initialize the genneric type
            return results;
        }
        
        List<Integer> dataList = new ArrayList<Integer>();
        List<Integer> tempList = new ArrayList<Integer>();
        for(int n : nums)
            dataList.add(n);
        
        backtracking(dataList, tempList, results);
        
        return results;
    }
    
    public void backtracking(List<Integer> dataList, List<Integer> tempList, List<List<Integer>> results){
        if(dataList.size() == 1){
            tempList.add(dataList.remove(0));
            results.add(tempList);
            return;
        }
            
        for(int i = 0; i < dataList.size(); i++){
            int chosedNum = dataList.get(i);
            
            //copy list
            List<Integer> copyDataList = new ArrayList<Integer>();
            List<Integer> copyTempList = new ArrayList<Integer>();
            for(int j = 0; j < dataList.size(); j++)
                if(j != i)
                    copyDataList.add(dataList.get(j));
            for(Integer n : tempList)
                copyTempList.add(n);
            copyTempList.add(chosedNum);
            
            backtracking(copyDataList, copyTempList, results);
        }
        
    }*/
    
    //avoid copy using visited array,beats 40%
    /*public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            result.add(new ArrayList<Integer>());
            
        }else{
            Boolean[] visited = new Boolean[nums.length];
            List<Integer> path = new ArrayList<Integer>();
            for(int i = 0; i < visited.length; i++){
                visited[i] = false;
                path.add(0);
            }
            
            _permute(nums, visited, 0, path, result);
        }
        
        return result;
    }
    
    public void _permute(int[] nums, Boolean[] visited, int step, List<Integer> path,List<List<Integer>> result){
        if(step == nums.length){
            List<Integer> copyList = new ArrayList<Integer>();
            for(int n : path)
                copyList.add(n);
            result.add(copyList);
            
        }else{
            for(int i = 0; i < nums.length; i++){
                if(visited[i])
                    continue;
                    
                path.set(step, nums[i]);
                visited[i] = true;
                
                _permute(nums, visited, step+1, path, result);
                visited[i] = false; //reset
            }
            
        }
    }*/
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            result.add(new ArrayList<Integer>());
            
        }else{
            List<Integer> numList = new ArrayList<Integer>();
            for(int n : nums)
                numList.add(n);
                
            _permute(numList, new ArrayList<Integer>(), result);
        }
        
        return result;
    }
    
    //remove element from numsList to pathList
    public void _permute(List<Integer> nums, List<Integer> path, List<List<Integer>> result){
        if(nums.size() == 0){
            List<Integer> copyList = new ArrayList<Integer>();
            for(int n : path)
                copyList.add(n);
            result.add(copyList); //endpoint of the recursion, copy path & save

        }else{
            for(int i = 0; i < nums.size(); i++){
                path.add(nums.remove(0));
                _permute(nums, path, result);
            }
        }
        
        if(path.size() > 0)
            nums.add(path.remove(path.size() - 1)); //add back the visited element
    }
}
