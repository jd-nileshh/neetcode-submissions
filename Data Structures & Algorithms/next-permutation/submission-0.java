class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int pivot = -1;

        for(int i = n-2 ; i>= 0 ;i--){
            if(arr[i] < arr[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            reverse(arr, 0 , n-1);
            return;
        }
        for(int i = n-1 ; i> pivot ; i--){
            if(arr[i] > arr[pivot]){
                int temp = arr[pivot];
                arr[pivot] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        reverse(arr, pivot + 1 , n-1);
    }
    void reverse(int[] arr, int low, int high){
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}