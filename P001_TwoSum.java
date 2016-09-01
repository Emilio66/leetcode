public class Solution {
    /**
     * @See Problem: https://leetcode.com/problems/two-sum/ 
     * 1. basic solution: traverse the array twice, to find the pair
     * 2. better:  two hashmap, map<number, index> + mapcopy(store duplicate data), query O(1) 
     * 3. optimized: O(n),  trade space for time, space cost depends on max - min
     * 
     * */
     //solution 1 , 39ms
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            //int a   =   nums[i];
            //target maybe negative, it's not right to skip them
            /*if(target > 0 && a > target)
                continue;*/
            //if it occurs in the previous passing, it will return, so start from i+1
            for(int j = i+1; j < nums.length; j++){
                //one number is not allowed
                //if(i == j)
                //    continue;
                // no temp variable
                //int b   =   nums[j];
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        
        return null;
    }
    
     //solution 2, 9 ms
     public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map   	=   new HashMap<Integer, Integer>((int)(nums.length * 1.34)); //avoid remap
        Map<Integer, Integer> mapCopy   =   new HashMap<Integer, Integer>();    //not much duplicates
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], i);
            else if(!mapCopy.containsKey(nums[i]))
                mapCopy.put(nums[i],i); //since the later will overwrite the former, so stop them if exist
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Integer counterpart   =   map.get(target - entry.getKey());
            //get another number, shouldn't be the same number
            if(counterpart == null || counterpart == entry.getValue()){
                //find in the copy
                counterpart =   mapCopy.get(target - entry.getKey());
            }
            if(counterpart != null){
                return new int[]{entry.getValue(), counterpart};
            }
            
        }
        
        return null;
      }
     
     //solution 3, 2ms
    public int[] twoSum(int[] nums, int target) {
        //use another array to store counterparts
        int min =   nums[0];
        int max =   nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > max)
                max =   nums[i];
            else if(nums[i] < min)
                min =   nums[i];
                
        }
        
        int validMin    =   target  -   max;
        int validMax    =   target  -   min;
        //save init time
        Integer[] partnerArray =   new Integer [validMax - validMin + 1];
        int curTarget   =   target  -   validMin;   //as partner array's index start from 0 not validMin
        
        //set its index for the other number while passing
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < validMin || nums[i] > validMax)
                continue;
            int index   =   nums[i] - validMin;
            //let the other number in the future knows his mate was here
            if(null == partnerArray[index])
                partnerArray[curTarget - nums[i]]    =   i;
            else
                return new int[] {partnerArray[index], i};
        }
        
        return null;
    }
}
