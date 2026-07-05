class Solution {
    public int maxArea(int[] heights) {
        int max = 0; 
        int area = 0;

        int left = 0; 
        int right = left + 1; 

            while(left < right) { 

                if (left == heights.length || right == heights.length) break; 
                int width = right - left; 
                int height = Math.min(heights[left], heights[right]);
    
                area = width * height; 
                max = Math.max(max, area); 

                if(right == heights.length - 1) {
                    left++; 
                    right = left + 1; 
                } else { 
                    right++; 
                }        
          
                
            }

            return max; 
        }
}
