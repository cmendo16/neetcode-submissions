class Solution {
    public boolean isAnagram(String s, String t) {
       // if they are not the same length then they 
       // are not anagrams
       if(s.length() != t.length() ) return false; 

       // create a hash map for each one 
       HashMap<Character, Integer> mapS = new HashMap<>(); 
       HashMap<Character, Integer> mapT = new HashMap<>(); 

       for(int i = 0; i < s.length(); i++) { 
           mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1); 
       }

       for(int i = 0; i < t.length(); i++) { 
           mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1); 
       }


       return mapS.equals(mapT);
    }
}