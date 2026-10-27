public class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0 ) { return false; } // early exit 

        Deque<Character> deque = new ArrayDeque<>(); 
        HashMap<Character, Character> map = new HashMap<>(); 
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        char[] sArray = s.toCharArray(); 

        for(char c : sArray) { 
            if(!map.containsKey(c)) { 
                deque.push(c); 
            } else if(map.containsKey(c)) {
                if(deque.isEmpty()) {
                    return false;
                }
                char parenthesis = deque.pop(); 
                if(parenthesis != map.get(c)) { 
                    return false; 
                }
            } 
        }

        return deque.isEmpty() ; 
    }
}