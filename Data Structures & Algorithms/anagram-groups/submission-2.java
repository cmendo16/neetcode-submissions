class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // can use a sorted string as a key, store list of strings as the values 
        HashMap<String, List<String>> map = new HashMap<>(); 

        for(String s : strs) {
            // array to hold all alphabetical characters
            int[] characters = new int[26]; 

            for(int c : s.toCharArray()) {
                // will increment the position, any anagrams will have the same array
                characters[c - 'a']++; 
            } 

            String key = Arrays.toString(characters); 

            map.putIfAbsent(key, new ArrayList<>()); 

            map.get(key).add(s); 
        }

        return new ArrayList<>(map.values());

    }
}
