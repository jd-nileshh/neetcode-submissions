class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        char[] ans = new char[arr1.length + arr2.length];

        int n = Math.min(arr1.length , arr2.length);

        int left = 0;
        int right = 0;
        int idx = 0;

        while(left < n && right < n){
           ans[idx++] = arr1[left++];
           ans[idx++] = arr2[right++];
        }
        while(left < arr1.length){
            ans[idx++] = arr1[left++];
        }
        while(right < arr2.length){
            ans[idx++] = arr2[right++];
        }
        return new String(ans);
    }
}