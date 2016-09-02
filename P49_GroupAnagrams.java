public class Solution {
    /**
     * 1. use basic isAnagram function & a representer list to judge one by one 
     * 2. hashMap<sum, List> , roughly group, use the sum of all letters as the key of string list, then divide
     * 
     * */
     //Time out solution
    /*public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramList  =   new ArrayList<>(strs.length);
        List<String>    groupList       =   new ArrayList<String>();    //each group's representers
        
        for(String word : strs){
            int i = -1;
            for(i = 0; i < groupList.size(); i++){
                if(isAnagram(groupList.get(i), word))
                    break;
            }
            
            //not found, new a group
            if(i < 0 || i == groupList.size()){
                groupList.add(word);            //append new representer
                
                List<String> group  =   new ArrayList<String>();
                group.add(word);
                anagramList.add(group);         //append new group
                
            }else{
                anagramList.get(i).add(word);   //append new element to group
                
            }
        }
        
        return anagramList;
    }*/
    
    //solution 2, 29ms
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupList = new ArrayList<>(strs.length);
        Map<Integer, List> sumListMap = new HashMap<>((int)(strs.length * 1.34));
        
        //aggregate similar words in a rough way
        for(String word : strs){
            int sum = 0;
            
            for(char ch : word.toCharArray())
                sum += ch;
                
            List similarWordList = sumListMap.get(sum);
            if(null == similarWordList){
                similarWordList = new ArrayList<String>();
                sumListMap.put(sum, similarWordList);
            }
            similarWordList.add(word);
            
        }
        
        //divide into anagram groups precisely
        for(Map.Entry<Integer, List> e : sumListMap.entrySet()){
            List<String> similarWords = e.getValue();
            
            //only 1 element
            if(similarWords.size() == 1){
                groupList.add(similarWords);
                continue;
            }
            
            List<List<String>> minorGroups = new ArrayList<>();
            for(int i = 0; i < similarWords.size(); i++){
                String str = similarWords.get(i);
                
                //whether it should be divided into current groups
                boolean isFound = false;
                for(int j = 0; j < minorGroups.size(); j++){
                    List<String> group = minorGroups.get(j);
                    
                    if(isAnagram(str, group.get(0))){
                        group.add(str);     //add new element to anagram group
                        isFound = true;
                        break;
                    }
                }
                
                //no, create a new group
                if(!isFound){
                    List<String> group = new ArrayList<>();
                    group.add(str);
                    minorGroups.add(group);
                    
                }
            }
            
            groupList.addAll(minorGroups);  //add to result
        }
        
        return groupList;
    }
    
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int[] counter   =   new int[26];    //key is letter, value is their occurrence s
        
        for(char ch : s.toCharArray()){
            counter[ch - 'a'] ++;  
        }
        for(char ch : t.toCharArray()){
            counter[ch - 'a'] --;
        }
        
        for(int i = 0; i < 26; i++)
            if(counter[i] != 0)    //not zero
                return false;
                
        return true;
    }
    
}
