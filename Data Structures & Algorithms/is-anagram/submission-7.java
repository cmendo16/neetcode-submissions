class Solution {
    public boolean isAnagram(String s, String t) {
        // if not the same length, not an anagram 
        if (s.length() != t.length()) { 
            return false; 
        }

        int[] arrayS = new int[26]; 
        int[] arrayT = new int[26];


        // track the position of each character
        for(int i = 0; i < s.length(); i++) { 
            arrayS[s.charAt(i) - 'a']++; 
            arrayT[t.charAt(i) - 'a']++; 
        }

        for(int i = 0; i < arrayS.length; i++) { 
            if(arrayS[i] != arrayT[i]) { 
                return false; 
            }
        }


        return true; 


    }
}
