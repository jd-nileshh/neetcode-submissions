class Solution {
    public int search(int[] nums, int target) {
        int k = 0;
        for(int i = 1 ;i<nums.length ;i++){
            if(nums[i] < nums[i-1]){
                k = i;
                break;
            }
        }
        int left = BinarySearch(nums,0,k-1,target);
        int right = BinarySearch(nums,k,nums.length - 1 ,target);

        if(left != -1){
            return left;
        }
        return right;
    }

    public int BinarySearch(int[]nums , int low , int high , int target){
        
        while(low <= high){
            int mid = low+(high-low)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
