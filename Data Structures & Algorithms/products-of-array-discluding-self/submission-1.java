class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length]; 
        int prefix = 1; 
        int postfix = 1; 

        // calculate the prefix values 
        for(int i = 0; i < result.length; i++) {
            result[i] = prefix; 
            // update the prefix every time 
            prefix *= nums[i]; 
        }

        // calculate the postfix 
        for(int i = result.length - 1; i >= 0; i--) { 
            result[i] *= postfix; 
            // calculcate the postfix everytime 
            postfix *= nums[i]; 
        }

        return result; 
    }
}  
 