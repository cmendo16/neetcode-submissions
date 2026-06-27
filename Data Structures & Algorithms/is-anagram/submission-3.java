class Solution {
    public boolean isAnagram(String s, String t) {
        // anagrams should be the same length 
        if(s.length() != t.length()) return false; 

        // array for all letters in the alphabet 
        int[] letters = new int[26]; 

        for(int i = 0; i < s.length(); i++) {
            // the syntax here returns the letters position in the array
            // 'b' - 'a' = 2 -> index 2
            letters[s.charAt(i) - 'a']++; 
            letters[t.charAt(i) - 'a']--; 
        }

        // we have an anagram if everything in the array is 0 
        for(int l : letters) {
            if(l != 0) return false; 
        }

        return true; 
    }
}