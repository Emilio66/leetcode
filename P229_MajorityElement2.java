public class Solution {
    
    //Boyer–Moore majority vote, O(n), beats 40%
   public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new ArrayList<Integer>();
        if(nums.length == 0)
            return results;
       
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 1;
        int count2 = 1;
      
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];

            if (temp == candidate1) {
                  count1++;
                    
            }else if (temp == candidate2) {
                count2++;

            }else if(count1 == 0){
                candidate1 = temp;
                count1 = 1;
                    
            }else if (count2 == 0) {
                candidate2 = temp;
                count2 = 1;
                    
            }else{
                count1 --;
                count2 --;
                    
            }
        }
            
        //check again
        count1 = 0;
        count2 = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] == candidate1)
                count1++;
            else if(nums[j] == candidate2) //if candidate1 == candidate2, the latter won't get any count
                count2++;
        }
            
        if (count1 * 3 > nums.length)
            results.add(candidate1);
        if (count2 * 3 > nums.length)
            results.add(candidate2);

        return results;
    }
    
    //Monte Carlo method, randomly sampling
    //the probability of failure is: (1/3)^20 + (2/3)^20 < 0.0003
    /*public List<Integer> majorityElement(int[] nums){
        List<Integer> results = new ArrayList<Integer>();
        if(nums.length == 0)
            return results;
        
        Random R = new Random();
        
        for(int i = 0; i < 20; i++){
            int random = nums[R.nextInt(nums.length)];
            int count = 0;
            for(int j = 0; j < nums.length; j++)
                if(nums[j] == random)
                    count++;
            
            if(count > nums.length / 3 && !results.contains(random))
                results.add(random);
        }
        
        return results;
    }*/
    
}
