class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) return false;

        int left = 0;

        int[] s1Chars = new int[26];
        int[] windowChars = new int[26];

        for (Character c : s1.toCharArray()) {
            s1Chars[c - 'a']++;
        }

        for (int right = 0; right < s2.length(); right++) {
            windowChars[s2.charAt(right) - 'a']++;

            while (right - left + 1 > s1.length()) {
                windowChars[s2.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == s1.length()) {
                if (Arrays.equals(windowChars, s1Chars)) {
                    return true;
                }
            }
        }

        return false;
    }
}