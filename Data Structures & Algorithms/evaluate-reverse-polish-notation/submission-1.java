class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<String, java.util.function.BinaryOperator<Integer>> ops = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b
        );

        for (String token : tokens) {
            if (ops.containsKey(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(ops.get(token).apply(a, b));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}