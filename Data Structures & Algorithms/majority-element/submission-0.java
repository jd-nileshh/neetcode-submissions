class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i< nums.length ; i++){

            map.put(nums[i] , map.getOrDefault(nums[i],0) + 1);

        }

        int maxCount = 0 ;
        int answer = nums[0];

        for(int key : map.keySet()){

            int freq = map.get(key);
            if(freq > maxCount){
                maxCount = freq;
                answer = key;
            }
        }
        return answer;
    }
}