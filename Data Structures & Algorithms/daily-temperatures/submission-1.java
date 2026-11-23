public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<int[]> deque = new ArrayDeque<>(); 

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!deque.isEmpty() && t > deque.peek()[0]) {
                int[] pair = deque.pop();
                res[pair[1]] = i - pair[1];
            }
            deque.push(new int[]{t, i});
        }
        return res;
    }
}