class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); 

        for(int i = 0; i < strs.size(); i++) { 
            sb.append(strs.get(i).length()).append("#").append(strs.get(i));
        }

        return sb.toString(); 
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>(); 
        // get the first '#' 
        int i = 0; 
        while(i < str.length()) { 
             // get the length of the string 
        int hash = str.indexOf('#', i);
        int length = Integer.parseInt(str.substring(i, hash)); 

        // get the string 
        String s = str.substring(hash + 1, length + hash + 1); 
        strs.add(s);
        i = hash + length + 1; 

        }
       
        return strs; 
    }
}
