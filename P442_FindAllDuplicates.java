public class Solution {
    
    //flip-flop, turn element to Negative, beats 49.66 %
    /*public List<Integer> findDuplicates(int[] nums) {
        List<Integer> copies = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int toBeFlipped = nums[i];
            
            if(toBeFlipped < 0)
                toBeFlipped = - toBeFlipped;
                
            toBeFlipped--; //indices is 0 based
            
            if(nums[toBeFlipped] < 0)
                copies.add(toBeFlipped + 1);  //index represents the element, negative means has been flipped
            else    
                nums[toBeFlipped] = -nums[toBeFlipped]; //flip
        }
        
        return copies;
    }*/
    
    //flip-flop neat version, beats 77.93%
    /*public List<Integer> findDuplicates(int[] nums) {
        List<Integer> copies = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            
            int flip = Math.abs(nums[i]) - 1;
            
            if(nums[flip] > 0)
                nums[flip] = - nums[flip]; //flip when hasn't been flipped
            else
                copies.add(flip + 1);
        }
        
        return copies;
    }*/
    
    //plus n, num[i] > 2n when duplicate, beats 96.94%
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> copies = new ArrayList<Integer>();
        int N = nums.length;
        
        for(int i = 0; i < nums.length; i++){
            nums[(nums[i] - 1) % N] += N;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 2 * N)
                copies.add(i + 1);
        }
        
        return copies;
    }
    
}
