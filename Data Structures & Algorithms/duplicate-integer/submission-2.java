class Solution {
    public boolean hasDuplicate(int[] nums) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>(); 

        for(int i = 0; i < nums.length; i++) {
            if(hashtable.containsKey(nums[i]) == false) {
                hashtable.put(nums[i], 1);
            } else { 
                return true; 
            }
        }

        return false; 
    }
}