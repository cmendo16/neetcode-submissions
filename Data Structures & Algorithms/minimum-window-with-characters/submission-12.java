class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return ""; 

        HashMap<Character, Integer> need = new HashMap<>(); 
        HashMap<Character, Integer> window = new HashMap<>(); 
        int left = 0; 
        int requiredCharsSeen = 0; 
        int shortestStringLength = Integer.MAX_VALUE; 
        int substringStart = 0; 
        int substringEnd = 0; 

        for(char c : t.toCharArray()) { 
            need.put(c, need.getOrDefault(c, 0) + 1); 
        }
        int requiredCharsNeeded = need.size(); 

        for(int right = 0; right < s.length(); right++) { 
            // expand the window 
            char rightChar = s.charAt(right); 
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1); 

            // check if the current char exists in need map, and 
            // check if counts are the same
            if(need.containsKey(rightChar) && need.get(rightChar).intValue() == window.get(rightChar).intValue()) { 
                requiredCharsSeen++; 
            }
            // check if we have seen all the required characters 
            while(requiredCharsSeen == requiredCharsNeeded) { 
                // check to see if we have seen the shortest string 
                if(right - left + 1 < shortestStringLength) { 
                    shortestStringLength = right - left + 1; 
                    substringStart = left; 
                    substringEnd = right; 
                }

                // remove/update leftmost char
                char leftChar = s.charAt(left); 
                window.put(leftChar, window.get(leftChar) - 1); 

                if(window.get(leftChar) == 0) { 
                    window.remove(leftChar); 
                }

                // if the left character removed 
                // was one of the characters that we needed. 
                // we need to update our char tracker
                if((need.containsKey(leftChar) && need.get(leftChar) > window.getOrDefault(leftChar, 0))) { 
                    requiredCharsSeen--; 
                }
                left++; 
            }
         }

         return shortestStringLength == Integer.MAX_VALUE ? "" : s.substring(substringStart, substringEnd + 1); 
        
    }
}