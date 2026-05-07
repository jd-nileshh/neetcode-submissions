class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        for(int i = 0 ; i< stones.length ; i++){
            pq.add(stones[i]);
        }
        int ans = weight(pq);

        return ans;
    }

    public int weight(PriorityQueue<Integer> pq){
        while(pq.size() != 1){
            int x = pq.poll();
            int y = pq.poll();

            if(x == y){
                pq.add(0);
                continue;
            }else if(x < y){
                pq.add(y-x);
            }else{
                pq.add(x-y);
            }
        }
        return pq.peek();
    }
}
