class Solution {
    public boolean isAnagram(String s, String t) {
        // anagrams should be the same length
        if(s.length() != t.length()) return false; 

        // keep an array that will keep track of counts 

        int count[] = new int[26]; 
        
        for(int i = 0; i < s.length(); i++) { 

            /* 
            In java, characters are just numers (their ASCII value). 
            When you subtract 'a' (97) from any lowercase letter, 
            you get its position in the alphabet. 

            Example: 
            'a' - 'a' = 0   → index 0
            'c' - 'a' = 2   → index 2

            ++ and -- → cancel each other out if 
            the same character appears the same number of times in both strings.

            */
            count[s.charAt(i) - 'a']++; 
            count[t.charAt(i) - 'a']--; 
        }

        for(int c : count) { 
            if(c != 0 ) return false;
        }

        return true; 


    }
}