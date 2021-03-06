public class Solution {
    /**
     * 1. O(n^2) solution, Brute Force, find the gap for every two elements, get the maximum
     * 2. O(n), compare with the next one, if it > next, compute gap, else replace it with the next one 
     * 
     * */
    public int maxProfit(int[] prices) {
        
        int buy = 0;
        int len =   prices.length;
        if(len < 2)
            return 0;
            
        //if the array are in a descending order, skip them
        while(buy < len - 1){
            if(prices[buy] < prices[buy + 1])
                break;
            buy ++;
        }
            
        int max =   0;
        int gap =   0;
        int sell =   buy + 1;
        while(sell < len){
            if(prices[sell] >= prices[buy]){
                if( ( gap = (prices[sell] - prices[buy]) ) > max )
                    max =  gap;
            }
            else
                buy = sell;  //use the smaller buying price to replace the previous one
            
            sell ++;
        }
       
        return max;
    }
    /*
    //similar solution
    public int maxProfit(int[] prices) {
        int l = prices.length;
        if( l < 2 )    return 0;
        int min = Integer.MAX_VALUE, profit=0;
        for(int i=0; i<l; i++){
            min = ( prices[i] < min) ? prices[i] : min; 
            profit = ( prices[i] - min > profit ) ? prices[i] - min : profit;
        }
        return profit;
    }*/
}
