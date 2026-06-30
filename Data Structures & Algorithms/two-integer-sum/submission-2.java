class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key = integer, value = index 
       HashMap<Integer, Integer> map = new HashMap<>(); 

       for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) { 
                map.put(nums[i], i); 
            }

            int complement = target - nums[i]; 
            if(map.containsKey(complement) && i != map.get(complement)) { 
                return new int[]{map.get(complement), i}; 
            }
       }

       return new int[]{}; 


    }
}
