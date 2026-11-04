class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String s : tokens) {
            switch (s) {
                case "+": {
                    int y = deque.pop();
                    int x = deque.pop();
                    deque.push(x + y);
                    break;
                }
                case "-": {
                    int y = deque.pop();
                    int x = deque.pop();
                    deque.push(x - y);
                    break;
                }
                case "*": {
                    int y = deque.pop();
                    int x = deque.pop();
                    deque.push(x * y);
                    break;
                }
                case "/": {
                    int y = deque.pop();
                    int x = deque.pop();
                    deque.push(x / y);
                    break;
                }
                default:
                    deque.push(Integer.parseInt(s));
                    break;
            }
        }

        return deque.pop();
    }
}