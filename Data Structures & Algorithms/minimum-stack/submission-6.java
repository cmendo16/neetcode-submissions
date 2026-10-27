class MinStack {
    private Stack<Integer> minStack; 
    private Stack<Integer> mainStack; 

    public MinStack() {
        minStack = new Stack<>(); 
        mainStack = new Stack<>(); 
    }
    
    public void push(int val) {
        mainStack.push(val); 

        if(minStack.isEmpty() || val <= minStack.peek()) { 
            minStack.push(val);
        }
    }
    
    public void pop() {
      if(mainStack.isEmpty()) return; 

      int popped = mainStack.pop(); 

      if(popped == minStack.peek()) { 
         minStack.pop(); 
      }
    }
    
    public int top() {
         return mainStack.peek(); 
    }
    
    public int getMin() {
       return minStack.peek(); 
    }
}
