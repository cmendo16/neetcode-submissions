class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs) { 
            String length = String.valueOf(s.length());
            sb.append(length).append('#').append(s); 
        }

        return sb.toString(); // return a single string
    }

    public List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    int i = 0;

    while (i < str.length()) {
        int j = str.indexOf("#", i);         
        int length = Integer.parseInt(str.substring(i, j));
        String s = str.substring(j + 1, j + 1 + length);
        i = j + 1 + length;                  
        result.add(s);
    }

    return result;
}
}
