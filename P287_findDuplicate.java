public class Solution {
    //brute force, beats 4.09 %
    /*public int findDuplicate(int[] nums) {
        int copy = nums[0];
        if(nums.length > 2){
            for(int i = 0; i < nums.length - 1; i++){
                copy = nums[i];
                for(int j = i + 1; j < nums.length; j++){
                    if(copy == nums[j])
                        return copy;
                }
                
            }
        }
            
        return copy;
    }*/
    
    //inserting sort inspired; not applied, should not modify source data
    /*public int findDuplicate(int[] nums) {
        int copy = nums[0];
        
        if(nums.length > 2){
            for(int i = 1; i < nums.length; i++){
                copy = nums[i];
                int j = i - 1;
                
                while(j >= 0){
                    if(copy == nums[j])
                        return copy;
                    if(nums[j] > copy)
                        nums[j + 1] = nums[j];
                    else
                        break;
                }
                
                nums[j] = copy;
            }
        }
        
        return copy;
    }*/
    
    //counting array, beats 51.1%, dosen't meet requirement, use O(n) space
    /*public int findDuplicate(int[] nums) {
        if(nums.length > 2){
            boolean[] flags = new boolean[nums.length - 1];
            
            for(int i = 0; i < nums.length; i++){
                if(flags[nums[i] - 1] == true)
                    return nums[i];
                flags[nums[i] - 1] = true;
            }
        }
        
        return nums[0]; 
    }*/
    
    //binary search based, O(nlogn) beats 37.3 %
    //idea: if the number of data that is less than current number, duplicates occur in left part
    /*public int findDuplicate(int[] nums) {
        
        int left = 1, right = nums.length - 1; 
        
        while(left < right){
            int mid = (left + right) / 2;
            int count = 0;
            
            for(int n : nums)
                if(n <= mid)
                    count++;
                    
            if(count > mid)
                right = mid; //take care
            else
                left = mid + 1; //move forward in case of integer division mistakes
        }
        
        return left;
    }*/
    
    //Floyd Circle based, beats 57.6 %
    //Two pointer: one fast, one slow, the second meet at duplicate
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[slow]; //two times fast in speed
        
        while(true){
            if(slow == fast)
                break;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        //reset
        slow = 0;
        while(true){
            if(slow == fast)
                break; //meet at circle's start point, i.e. the first duplicate
            slow = nums[slow];
            fast = nums[fast]; //same speed
        }
        
        return slow;
    }
    
}
