class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

    int row = -1;
        for(int i = 0; i<m ;i++){
            if(matrix[i][n-1] >= target){
                row = i;
                break;
            }
        }

        if(row == -1) return false;
        
        int ans = BinarySearch(matrix, target , row);
        if(ans != -1){
            return true;
        }
        return false;
    }

    public int BinarySearch(int[][] matrix, int target, int row){
        int low = 0 ;
        int high = matrix[0].length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(matrix[row][mid] == target){
                return mid;
            }else if(matrix[row][mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
