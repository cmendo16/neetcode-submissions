class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     // use the bucket sort algorithm 
    
     HashMap<Integer, Integer> map = new HashMap<>(); 

     // map each number to its frequency 
    for(int n : nums) {
        map.merge(n, 1, Integer::sum); 
    }

    // Create a list of buckets: index - frequency and value is list of nums 
    // with that frequency 
    List<Integer>[] buckets = new List[nums.length + 1]; 

    for(int key : map.keySet()) {
        int freq = map.get(key);  

        if(buckets[freq] == null) {
            buckets[freq] = new ArrayList<>(); 
        }

        buckets[freq].add(key);
    }

    // iterate buckets highest freq to lowest freq, collect top k 

    int index = 0; 
     int[] result = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[idx++] = num;
                    if (idx == k) break;
                }
            }
        }

        return result;
    }
}
