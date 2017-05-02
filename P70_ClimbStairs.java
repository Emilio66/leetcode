public class Solution {
    //similar to Fibonacci Array: RECCURENT Solution EXCEED TIME LIMIT
    /*public int climbStairs(int n) {
        if(n < 2) return 1;
        else return climbStairs(n-1) + climbStairs(n-2);
    }*/
    
    //Solution1: bottom up, sliding window [2 number, move forward]
    public int climbStairs(int n) {
        if(n < 2) return 1;
        int n1 = 1, n2 = 1, res = 0;
        for(int i = 2; i <= n; i++){
            res = n1 + n2;
            n1 = n2;
            n2 = res;
        }
        return res;
    }
        
    //solution 2: DFS + cache
    /*public Map<Integer, Integer> cacheMap = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        if(n < 2) return 1;
        cacheMap.put(0,1);
        cacheMap.put(1,1);
        return dfs(n);
    }
    
    public int dfs(int n){
        Integer res = cacheMap.get(n);
        if(res==null){
            res = dfs(n-1) + dfs(n-2);
            cacheMap.put(n, res);
        } 
        return res;
    }*/
    
    //Solution3: cache table 【singleton】
    /*public static int[] cache = new int[40];
    static{
        cache[0] = 1;
        cache[1] = 1;
        for(int i = 2; i < cache.length; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
    }
    
    public int climbStairs(int n) {
        if(n < 40) return cache[n];
        int n1 = cache[38], n2 = cache[39], res = 0;
        for(int i = 40; i <= n; i++){
            res = n1 + n2;
            n1 = n2;
            n2 = res;
        }
        return res;
    }*/

}
