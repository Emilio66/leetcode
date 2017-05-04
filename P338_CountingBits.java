public class Solution {
    //PATTERN: n & (n-1) will eliminate the last '1' in n
    //eliminate the bit 1 until 0
    /*private int _countBits(int n){
        int cnt = 0;
        while(n > 0){
            n &= n - 1;
            cnt++;
        }
        return cnt;
    }
    
    //Solution1: Fast Eliminate '1'
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 0; i <= num; i++)
            res[i] = _countBits(i);
        return res;
    }*/
    
    //Solution2: Recursion ~ Top-Down: f(n) = (n & 1 == 0) ? f(n>>1) : f(n>>1) + 1
    /*public int[] countBits(int num){
        int[] res = new int[num+1];
        for(int i = 0; i <= num; i++) dp(i, res);
        return res;
    }
    
    //DFS until it exists
    private void dp(int i, int[] res){
        if(i == 0) return;
        if(res[i>>1] == 0) dp(i>>1, res);
        res[i] = (i & 1) == 0 ? res[i>>1] : res[i>>1]+1;
    }*/
    
    //Solution3: Iterative DP ~ Bottom-Up [Beats 88%]
    public int[] countBits(int num){
        int[] res = new int[num+1];
        for(int i = 1; i <= num; i++)
            res[i] = res[i>>1] + (i & 1);
        return res;
    }
}
