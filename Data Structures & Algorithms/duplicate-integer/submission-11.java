class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); 

        for(int k : nums) { 
            if(!set.contains(k)) { 
                set.add(k); 
            } else { 
                return true; 
            }
        }

        return false; 
    }
}