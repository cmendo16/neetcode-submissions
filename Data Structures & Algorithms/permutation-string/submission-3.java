class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        // hashmap: characters and occurrences we need
        HashMap<Character, Integer> need = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // hashmap for our window
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0; // left ptr

        // build the initial window
        for (int i = 0; i < s1.length(); i++) {
            window.put(s2.charAt(i), window.getOrDefault(s2.charAt(i), 0) + 1);
        }

        // early check
        if (window.equals(need)) return true;

        for (int right = s1.length(); right < s2.length(); right++) {
         
            char rightChar = s2.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            char leftChar = s2.charAt(left);
            window.put(leftChar, window.get(leftChar) - 1);
            if (window.get(leftChar) == 0) {
                window.remove(leftChar);
            }
            left++;

            if (window.equals(need)) return true;
        }

        return false;
    }
}