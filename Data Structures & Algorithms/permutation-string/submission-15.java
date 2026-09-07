class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // we can use int arrays to count character occurences 
        int[] neededChars = new int[26]; 
        int[] window = new int[26]; 
        int left = 0; 
        int windowSizeCapacity = s1.length(); 

        // if s2 is shorter than s1, then we can exit early 
        if(s2.length() < s1.length()) return false; 

        // add the needed chars to the array 
        for(Character c : s1.toCharArray()) { 
            neededChars[c - 'a']++; 
        }

        

        // iterate through the second string 
        for(int right = 0; right < s2.length(); right++) {

            char rightChar = s2.charAt(right); 
            // expand the window, add the rightmost character 
            window[rightChar - 'a']++; 

            // only move left pointer once the window size is larger than expected
            while(right - left + 1 > windowSizeCapacity) { 
                char leftChar = s2.charAt(left); 
                window[leftChar - 'a']--; 
                left++; 
            }

            if(right - left + 1 == windowSizeCapacity) { 
                if(Arrays.equals(neededChars, window)) return true; 
            }

        }

        return false; 


    }
}