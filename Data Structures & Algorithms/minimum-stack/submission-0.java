class MinStack {
    Stack<Integer> stack ;
    Stack<Integer> copy ;

    public MinStack() {
       stack = new Stack<>();
       copy = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(copy.isEmpty()){
            copy.push(val);
        }else{
            copy.push(Math.min(val,copy.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        copy.pop();
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return copy.peek();
    }
}
