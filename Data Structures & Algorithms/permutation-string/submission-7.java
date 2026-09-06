class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()) return false; 

        int left = 0; // left ptr 
        int windowSize = s1.length(); 

        HashMap<Character, Integer> need = new HashMap<>(); 

        // fill in values for the characters that we are looking for 
        for(Character c : s1.toCharArray()) { 
            need.put(c, need.getOrDefault(c, 0) + 1); 
        }

        HashMap<Character, Integer> window = new HashMap<>(); 

        // initial window 
        for(int i = 0; i < windowSize; i++) { 
            // add first n values to our map 
            window.put(s2.charAt(i), window.getOrDefault(s2.charAt(i), 0) + 1); 
        }

        // early check, if both maps match then we can return true 
        if(window.equals(need)) return true; 

        // iterate through the remaining string 
        for(int right = windowSize; right < s2.length(); right++) { 
            char rightChar = s2.charAt(right); 

            // expand our window, add right element to our window 
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1); 

            // get the left character 
            char leftChar = s2.charAt(left); 

            // update the occurence counter, if it reaches 0, then we can remove the element from the window 
            window.put(leftChar, window.get(leftChar) - 1); 

            if(window.get(leftChar) == 0) { 
                window.remove(leftChar); 
                
            }
left++; 
            

            // do another check to see if our window matches
             if(window.equals(need)) return true; 

        }

        return false; 
    }
}