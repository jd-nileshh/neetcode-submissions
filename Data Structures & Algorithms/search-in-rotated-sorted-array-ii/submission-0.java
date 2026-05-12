class Solution {
    public boolean search(int[] nums, int target) {
        int k = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] < nums[i-1]){
                k = i;
                break;
            }
        }
        int left = BinarySearch(nums,target,0,k-1);
        int right = BinarySearch(nums,target,k,nums.length - 1);

        if(left != - 1 || right != -1){
            return true;
        }
        return false;
    }

    public int BinarySearch(int[] nums , int target , int low ,int high){
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                ans = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}
