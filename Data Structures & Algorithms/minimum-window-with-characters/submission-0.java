class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> needed = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            needed.put(c, needed.getOrDefault(c, 0) + 1);
        }

        int required = needed.size(); 
        int formed = 0;                

        int left = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            if (needed.containsKey(rightChar) &&
                window.get(rightChar).intValue() == needed.get(rightChar).intValue()) {
                formed++;
            }

            // shrink while window is valid
            while (formed == required) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (needed.containsKey(leftChar) &&
                    window.get(leftChar) < needed.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}