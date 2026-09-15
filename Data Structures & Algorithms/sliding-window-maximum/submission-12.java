class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int len = nums.length; 
       int[] result = new int[len - k + 1]; 
       int left = 0; 
       int right = 0; 
       Deque<Integer> deque = new LinkedList<>(); 

       while (right < len) { 
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[right]) { 
                deque.removeLast(); 
            }
       

       deque.addLast(right); 

       if(left > deque.getFirst()) {
            deque.removeFirst(); 
       }

            if ((right + 1) >= k) {
                result[left] = nums[deque.getFirst()];
                left++;
            }
            right++;
       }

       return result; 
    }
}