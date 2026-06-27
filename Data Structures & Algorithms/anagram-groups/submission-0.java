class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>(); 

        for(String str : strs) {
            int[] count = new int[26]; 

            // count the occurence of each character
            // it does not matter the order, if two strings are anagrams, 
            // they will produce the same key 
            for(char c : str.toCharArray()) {
                count[c - 'a']++; 
            }

            String key = Arrays.toString(count);

            // if the map doesn't contain the key, add it to the map
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // if it does contain the key, add the original string to the list of lists
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
