class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayList<Integer> left = NSL(heights);
        ArrayList<Integer> right = NSR(heights);
        int n = heights.length;
        int[] width = new int[n];

        for(int i = 0 ;i<n ;i++){
            width[i] = right.get(i) - left.get(i) - 1;
        }
        int maxArea = 0;
        for(int i = 0 ; i < n ;i++){
            int area = heights[i] * width[i];
            maxArea = Math.max(area , maxArea);
        }
        return maxArea;
    }

    public ArrayList<Integer> NSL(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        int n = arr.length;

        for(int i = 0 ;i < n ;i++){
            if(stack.size() == 0){
                list.add(-1);
            }
            else if(stack.size() > 0 && stack.peek().first < arr[i]){
                list.add(stack.peek().second);
            }
            else if(stack.size() > 0 && stack.peek().first >= arr[i]){
                while(stack.size() > 0 && stack.peek().first >= arr[i]){
                    stack.pop();
                }if(stack.size() == 0){
                    list.add(-1);
                }else{
                    list.add(stack.peek().second);
                }
            }
            stack.push(new Pair(arr[i] , i));
        }
        //Collections.reverse(list);
        return list;
    }

    public ArrayList<Integer> NSR (int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        int n = arr.length;

        for(int i = n-1 ;i >= 0 ;i--){
            if(stack.size() == 0){
                list.add(n);
            }
            else if(stack.size() > 0 && stack.peek().first < arr[i]){
                list.add(stack.peek().second);
            }
            else if(stack.size() > 0 && stack.peek().first >= arr[i]){
                while(stack.size() > 0 && stack.peek().first >= arr[i]){
                    stack.pop();
                }if(stack.size() == 0){
                    list.add(n);
                }else{
                    list.add(stack.peek().second);
                }
            }
            stack.push(new Pair(arr[i] , i));
        }
        Collections.reverse(list);
        return list;
    }
}
