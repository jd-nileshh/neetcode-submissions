class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int pile : piles){
            max = Math.max(max , pile);
        }

        int ans = max;
        int low = 1;
        int high = max;

        while(low <= high){
            int mid = low + (high - low)/2;

            long hours = 0 ;
            for(int pile : piles){
                hours += (int)Math.ceil((double)pile/mid);
            }
            if(hours <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
