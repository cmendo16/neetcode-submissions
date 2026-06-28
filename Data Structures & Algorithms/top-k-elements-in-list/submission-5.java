class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     // hashmap where key: the integer in the array and value is the 
     // number of times that the value appears in the array 
     // increment value one time 
     HashMap<Integer, Integer> map = new HashMap<>(); 

     for(int i = 0; i < nums.length; i++) { 
        // if map does not contain the key, then add the key 
        // if it does, then just get the key and increment 
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); 
     }

     // inititalize an array of ArrayLists, where the index 
     // represents how many times the number appeared in the array 
    List<Integer>[] buckets = new ArrayList[nums.length + 1]; 

    // initialize an array list at each bucket 
   for (int i = 0; i < buckets.length; i++) {
    buckets[i] = new ArrayList<>();
}

  for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
     int frequency = entry.getValue(); 
     buckets[frequency].add(entry.getKey()); 
   }

     // we want to iterate k times over the buckets to find 
     // the top k elements, starting from the end of the array 
     int index = 0; 
     int[] result = new int[k]; // we want the top k elements 
     for(int i = buckets.length - 1; i >= 0 && index < k; i--) { 
         for(int j = 0; j < buckets[i].size(); j++) { 
            result[index] = buckets[i].get(j);
            index++; 
         }
     }
     return result; 
    }
}
