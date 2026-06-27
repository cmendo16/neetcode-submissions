class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // anagrams -> ex) 'act' and 'cat'

        // sorting the characters for any 2 strings that are anagrams will provide 
        // the same final sorted string 

        // hashmap -> key : sorted string, value: list of anagrams 

        // for each string turn into an array of characters 
        // we can then manipulate and sort it, convert back into string 
        // use the string as the key, and take the original string, and add it 
        // to the list of anagrams that share that same key. 

        HashMap<String, List<String>> anagramMap = new HashMap<>(); 

        for(String s : strs) {
            char[] characters = s.toCharArray(); 

            Arrays.sort(characters); 

            String sortedString = new String(characters); 

            if(!anagramMap.containsKey(sortedString)) { 
                anagramMap.put(sortedString, new ArrayList<String>());
            }

            anagramMap.get(sortedString).add(s);
        }

      return new ArrayList<>(anagramMap.values());

    }
}
