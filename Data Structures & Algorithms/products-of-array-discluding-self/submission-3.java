class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length]; 
        int prefix = 1; 
        int postfix = 1; 

        for(int i = 0; i < results.length; i++) { 
            results[i] = prefix; 
            prefix *= nums[i]; 
        }

        for (int i = results.length - 1; i >= 0; i--) {
            results[i] *= postfix; 
            postfix *= nums[i]; 
        }

        return results;
    }
}  
 