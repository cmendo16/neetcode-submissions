class Solution {
    public boolean hasDuplicate(int[] nums) {
        // use a hashset because it only stores unique values 
        // hashmaps store key-value pairs, which is not necessary here. 
        HashSet<Integer> set = new HashSet<>(); 

    
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                return true; 
            
            set.add(nums[i]);
        }
        
        return false; 
    }
}