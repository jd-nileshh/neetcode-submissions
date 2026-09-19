class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character , Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int count = 0;
        int left = 0;
        int right = 0;

        for(; right < arr.length ; right++){
            int idx = map.getOrDefault(arr[right] , -1);
            if(idx != -1 && idx >= left){
                count = Math.max(count , right - left);
                left = idx + 1;
            }
            map.put(arr[right] , right);
        }
        return Math.max(count , right - left);
    }
}
