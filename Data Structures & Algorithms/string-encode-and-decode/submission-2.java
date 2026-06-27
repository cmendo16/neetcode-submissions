class Solution {

    public String encode(List<String> strs) {
      // 1. declare and initialize the string builder 
        StringBuilder sb = new StringBuilder(); 

      // for each string in the list of strings, 
      // append to the sb: length of the string and '#', then the string itself 
      for(String s : strs) { 
        sb.append(s.length()).append('#').append(s); 
      }

      // 2. convert string builder to a new string and return 
      return sb.toString(); 
    }

    public List<String> decode(String s) {
        // 1. substring(inclusive, exclusive)
        List<String> strs = new ArrayList<>();
       
        int i = 0; 
        int t = 0; 
        while(i < s.length()) { 
            // we can extract the symbol '#' first at its position 
            int j = s.indexOf("#", i); 
       
            
            // get the position of the length of the string 
            int length = Integer.parseInt(s.substring(i, j)); 
            
            
            // now extract the string and add it to the list 
            // grab beginning and the end of the list 
            String str = s.substring(j + 1, j + 1 + length); 
            i = j + 1 + length; 

            strs.add(str); 
        }

        return strs; 
    }
}
