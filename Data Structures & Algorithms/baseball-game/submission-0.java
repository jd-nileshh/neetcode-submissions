class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        
        for(int i = 0 ; i < operations.length ; i++){
            if(operations[i].equals("+")){
                stack.push(stack.peek() + stack.get(stack.size()-2));
            }
            else if(operations[i].equals("C")){
                stack.pop();
            }
            else if(operations[i].equals("D")){
                stack.push(2*stack.peek());
            }else{
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}