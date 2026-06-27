class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // initialize a hashmap wher the key -> integer in the array, and the value is the occurrences
        HashMap<Integer, Integer> map = new HashMap<>(); 

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1); 
        }

        // create our buckets. List of lists 
        List<Integer>[] buckets = new ArrayList[nums.length + 1]; // add one for an offset? 

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>(); // each bucket will point to a list 
        }

        // iterate through the map using its keys 
        for(int key : map.keySet()) {
            int count = map.get(key); // get the value at that key 
            buckets[count].add(key); 
        }



        // return results 
        int index = 0; 
        int[] result = new int[k];

        for(int i = buckets.length - 1; i >=0 && index < k; i--) {
            for(int num : buckets[i]) {
                result[index++] = num; 
                if(index == k) return result; 
            }
        }

        return result; 
    }
}
