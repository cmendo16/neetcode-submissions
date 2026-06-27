class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); 

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int count = map.get(nums[i]); 
                if(count >= 1) {
                    return true;
                }
            } else { 
                map.put(nums[i], 1);
            }
        }

        return false; 
    }
}