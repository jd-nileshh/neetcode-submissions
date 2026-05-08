class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        

        for(int i = 0 ;i<n-1 ;i++){
            int maxVal = -1;
            for(int j = i+1 ;j<n ;j++){
                if(arr[j] > maxVal){
                    maxVal = arr[j];
                }
            }
            arr[i] = maxVal;
        }
        arr[n-1] = -1;
        return arr;
    }
}