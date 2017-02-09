public class Solution {
    //sorting first, beats 96.7%, not O(n) due to sorting
    /*public int longestConsecutive(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
            
        Arrays.sort(nums);

        int i = 1, max = 1;
        while (i < nums.length) {
            int cnt = 1;
            while (i < nums.length && (nums[i - 1] + 1 == nums[i] || nums[i - 1] == nums[i])) {
                if(nums[i - 1] + 1 == nums[i])
                    cnt++;  //same number doesn't count
                i++;
            }

            if (cnt > max)
                max = cnt;

            i++; //move forward
        }

        return max;
    }
    */
    
    //hash based, O(n), beat 86.85 %
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
    
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int n : nums)
            hashSet.add(n);
        
        //check whether the near subsequent number exist, if not, this is the end point, 
        // then find the start point, calculate the length between start and end, 
        // compare with the max length
        int max = 1;
        for (int n : nums){
            if(!hashSet.contains(n + 1)){
                int len = 1;
                while (hashSet.contains(n - 1)){
                    n--;
                    len++;
                }
                
                if (len > max)
                    max = len;
            }
        }
        
        return max;
    }
    
    class UnionFind{
        Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
        Map<Integer, Integer> size = new HashMap<Integer, Integer>();
        int maxSize = 1;

        public void add(int x){
            parent.put(x, x);
            size.put(x, 1);
        }

        //1. find the root
        //2. compress the path
        public int find(int x){
            int father = parent.get(x);

            while(father != parent.get(father))
                father = parent.get(father);

            //compress the path to 2-level structure
            while(parent.get(x) != father){
                int temp = parent.get(x);
                parent.put(x, father);
                x = temp;
            }

            return father;
        }

        //union two different families, choose the big family's root as the combined ancestor
        public void union(int x, int y){
            int xRoot = find(x);
            int yRoot = find(y);

            if(xRoot != yRoot){
                int xSize = size.get(xRoot); //family size
                int ySize = size.get(yRoot);
                int newSize = xSize + ySize;

                if(xSize > ySize){
                    parent.put(yRoot, xRoot); //the big one as root
                    size.put(xRoot, newSize);

                }else{
                    parent.put(xRoot, yRoot);
                    size.put(yRoot, newSize);
                }

                if(maxSize < newSize)
                    maxSize = newSize;
            }
        }
    }
    
    //union find based, beats 3.8 %
    /*public int longestConsecutive(int[] nums) {
        if(nums.length <= 1)
            return nums.length;

        UnionFind uf = new UnionFind();

        for (int n : nums){
            if(!uf.parent.containsKey(n))
                uf.add(n);

            if(uf.parent.containsKey(n - 1))
                uf.union(n, n - 1);

            if(uf.parent.containsKey(n + 1))
                uf.union(n, n + 1);

        }

        return uf.maxSize;
    }*/
}
