
public class Solution {
    /**
     * @See Problem: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     * Notice: it's 1-based, sorted array
     * 1. one-pass + binary search O(nlogn)
     * 2. second-pass hash map, trading space for speed
     * 3. one-pass, two cursor, one start from begining, the other from tail, similar to QuickSort
     * */
    public int[] twoSum(int[] numbers, int target) {
        int validMin    =   target  -   numbers[numbers.length - 1];
        int validMax    =   target  -   numbers[0];
        int validRight  =   numbers.length - 1;
        int validLeft   =   0;
        
        //avoid unecessary passing
        while(numbers[validRight]   >   validMax)
            validRight--;
        while(numbers[validLeft]    <   validMin)    
            validLeft++;
        
        
        //solution 1, 4ms
        /*for(int i = validLeft; i < validRight; i++){
            int result  =   Arrays.binarySearch(numbers, i + 1, validRight + 1, target - numbers[i]);
            //Notice: if not found, result is (-(insertion point) - 1), not -1; 1-based, remeber to add 1
            if(result > 0)
                return new int[] {i+1, result+1};
        }*/
        
        //solution 2, 6ms
        /*Map<Integer, Integer> map   =   new HashMap<Integer, Integer>((int)(numbers.length * 1.34));
        for(int i = validLeft; i < validRight; i++){
            //if(numbers[i] < validMin || numbers[i] > validMax)
            //    continue;
            map.put(numbers[i], i); //overwrite the former
        }
        
        //second pass is quicker than 1
        for(int i = validLeft; i < validRight; i++){
            //if(numbers[i] < validMin || numbers[i] > validMax)
            //    continue;
            Integer other;
            //no need to judge whether other == i because solution occurs before the half number
            if((other = map.get(target - numbers[i])) != null)
                return new int[] {i + 1, other + 1};  //1-based
        }
        */
        
        //solution3, 1ms
        int L   =   validLeft;  //cursor
        int R   =   validRight;

        while(L < R){
            while(numbers[R] > target - numbers[L])
                R--;
            if(numbers[R] + numbers[L] == target)
                return new int[] {L+1, R+1};
                
            while(numbers[L] < target - numbers[R])
                L++;
            if(numbers[R] + numbers[L] == target)
                return new int[] {L+1, R+1};
        }
        return null;
    }
}
