class Pair{
    int first;
    int second;

    Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayList<Integer> left = NSL(heights);
        ArrayList<Integer> right = NSR(heights);
        int[] width = new int[heights.length];
        for(int i = 0 ;i<heights.length ; i++){
            width[i] = right.get(i) - left.get(i) - 1;
        }
        int maxArea = 0;
        for(int i = 0 ;i<heights.length ;i++ ){
            int area = heights[i]*width[i];
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    public ArrayList<Integer> NSL(int[]arr){
        ArrayList<Integer> v = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        int n = arr.length;

        for(int i = 0 ; i < n ;i++){
            if(stack.size() == 0){
                v.add(-1);
            }
            else if(stack.size() > 0 && stack.peek().first < arr[i]){
                v.add(stack.peek().second);
            }
            else if(stack.size() > 0 && stack.peek().first >= arr[i]){
                while(stack.size() > 0 && stack.peek().first >= arr[i]){
                    stack.pop();
                }if(stack.size() == 0){
                    v.add(-1);
                }else {
                    v.add(stack.peek().second);
                }
            }
            stack.push(new Pair(arr[i] , i));
        }
        return v; 
    }

    public ArrayList<Integer> NSR(int[]arr){
        ArrayList<Integer> v = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        int n = arr.length;

        for(int i = n-1 ; i >=0 ;i--){
            if(stack.size() == 0){
                v.add(n);
            }
            else if(stack.size() > 0 && stack.peek().first < arr[i]){
                v.add(stack.peek().second);
            }
            else if(stack.size() > 0 && stack.peek().first >= arr[i]){
                while(stack.size() > 0 && stack.peek().first >= arr[i]){
                    stack.pop();
                }if(stack.size() == 0){
                    v.add(n);
                }else {
                    v.add(stack.peek().second);
                }
            }
            stack.push(new Pair(arr[i] , i));
        }
        Collections.reverse(v);
        return v; 
    }

}
