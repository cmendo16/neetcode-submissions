class Solution {
    public boolean hasDuplicate(int[] nums) {
        // use a hashset to store unique values 
        HashSet<Integer> set = new HashSet<>(); 
        // for each item in the list, if not in set, add it 
        // if any of the values appears more than once, return true 
        for(int num : nums) { 
            if(set.contains(num)) { 
                return true; 
            }

            set.add(num);
        }

        return false; 
    }
}