class Solution {
    public int scoreOfString(String s) {
        int count = 0;

        for(int i = 1 ; i< s.length() ;i++){
            int add =  Math.abs((int)s.charAt(i) - (int)s.charAt(i-1));
            count += add;
        }
        return count;
    }
}