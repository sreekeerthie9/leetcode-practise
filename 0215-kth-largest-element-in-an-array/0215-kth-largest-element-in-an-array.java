class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        int i=k;
        while(i<n){
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
            i++;
        }
        return pq.poll();
    }
}