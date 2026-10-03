class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> seen = new HashMap<>(); 

        for(int i = 0; i < nums.length; i++) { 
            int difference = target - nums[i]; 

            if(seen.containsKey(difference)) { 
                // get the smallest of the two numbers 
                if(i < seen.get(difference)) { 
                    return new int[]{i, seen.get(difference)}; 
                } else {
                    return new int[]{seen.get(difference), i}; 
                }
            }

            seen.put(nums[i], i);  
        }

        return new int[]{}; 
      
    }
}
