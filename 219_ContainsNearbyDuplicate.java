public class Solution {
    
    //brute force, Time limit exceeded
    /*public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length > 1){
            for(int i = 0; i < nums.length; i++){
                //difference <= k (including k !!)
                for(int j = 1; j <= k && (i + j < nums.length); j++){
                    if(nums[i] == nums[i+j])
                        return true;
                }
            }
        }
        
        return false;
    }*/
    
    //hash map based, beats 8.11 %
    /*public boolean containsNearbyDuplicate(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer val = null;
            if((val = map.get(nums[i])) != null && (i - val) <= k)
                return true;
            map.put(nums[i], i);
        }
        
        return false;
    }*/
    
    //combined version, beats 12.37 %
    //small dataset use brute force, big dataset use hashmap
    /*public boolean containsNearbyDuplicate(int[] nums, int k){
        if(nums.length > 1){
            if(nums.length < 20){
                for(int i = 0; i < nums.length; i++){
                    //difference <= k (including k !!)
                    for(int j = 1; j <= k && (i + j < nums.length); j++){
                        if(nums[i] == nums[i+j])
                            return true;
                    }
                }
        
            }else{
                Map<Integer, Integer> map = new HashMap<>();
                for(int i = 0; i < nums.length; i++){
                    Integer val = null;
                    if((val = map.get(nums[i])) != null && (i - val) <= k)
                        return true;
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }*/
    
    //Slide window, beats 99.18 %
    //Notice window's size large than nums.length
    public boolean containsNearbyDuplicate(int[] nums, int k){
        
        if(nums.length <= k || nums.length < 20){
            
            for(int i = 0; i < nums.length; i++){
                for(int j = 1; j <= k && (i + j < nums.length); j++){
                    if(nums[i] == nums[i+j])
                        return true;
                }
            }
            
        }else{
            
            Set<Integer> hashSet = new HashSet<Integer>((int)(k * 1.34));
            int start = k;
            for(int i = 0; i < k; i++){
                hashSet.add(nums[i]);
            }
            
            for(int i = start; i < nums.length; i++){
                if(i - start < k){
                    if(hashSet.contains(nums[i]))
                        return true;
                    
                }else{
                    //slide to next window
                    hashSet.clear(); 
                    for(int j = start; j < start + k; j++){
                        hashSet.add(nums[j]);
                    }
                    start += k;
                    
                }
            }
        }
        
        return false;
    }
    
}
