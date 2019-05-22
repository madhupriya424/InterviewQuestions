II. OWN STACK:

I.class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            minStack.push(Math.min(minStack.peek(), x));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 -----------------------------------------------------------------------------------------------------------------------------------
 II.
 
 class MinStack {
   private int top = -1;
   private int stack[];
   private int minStack[];
    
    /** initialize your data structure here. */
    public MinStack() {
    stack = new int[100000];
    minStack = new int[100000];    
    }
    
    public void push(int x) {
        top++;
        stack[top]=x;
        if(top==0)
            minStack[top] = x;
        else
            minStack[top] = Math.min(minStack[top-1], x);
    }
    
    public void pop() {
        int val = stack[top];
        top--;
    }
    
    public int top() {
        if(top==-1)
            return -1;
        return stack[top];
    }
    
    public int getMin() {
        return minStack[top];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
