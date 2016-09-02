public class Solution {
    /**
     * @See https://leetcode.com/problems/valid-anagram/
     * // using hashSet to store all alphabets for each string doesn't work because of duplicate letters
     * 1. use an array with size 26 to store all letters & their occurrences
     * 2. optimize: use one Counter Array, one increase, the other decrease, if not zero, return false
     * */
    
    //solution 1, 4ms
    /*public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int[] srcArr  =   new int[26];  //key is letter, value is their occurrence s
        int[] tarArr  =   new int[26];
        
        for(char ch : s.toCharArray())
            srcArr[ch - 'a']++;
        
        for(char ch : t.toCharArray())
            tarArr[ch - 'a']++;
        
        for(int i = 0; i < 26; i++)
            if(srcArr[i] != tarArr[i])
                return false;
                
        return true;
    }*/
    
    //solution2, 3ms
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int[] counter   =   new int[26];    //key is letter, value is their occurrence s
        
        //Tip1: Array access is faster than method invoke (charAt(i))
        //Tip2: locality matters, two individual iterations are better than one combined iteration like this:
        //7ms
       /* for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a'] ++;  
            counter[t.charAt(i) - 'a'] --;
        }*/
        
        for(char ch : s.toCharArray())
            counter[ch - 'a'] ++;  
        for(char ch : t.toCharArray())
            counter[ch - 'a'] --;
        
        for(int i = 0; i < 26; i++)
            if(counter[i] != 0)    //not zero
                return false;
                
        return true;
    }
}
