class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //int max = 0;
        //int min = Integer.MAX_VALUE;
        int p1=0;
        int p2=0;
        int i=0;

        int n = nums.length;
        int ans = 0;

        while(i<n-1){
            if(n-ans+1<i){
                return ans+1;
            }
            p1 = nums[i];
            p2 = nums[i];
            int j=i+1;
            while(j<n){
                p1 = Math.max(p1,nums[j]);
                p2 = Math.min(p2,nums[j]);
                if(Math.abs(p2-p1)<=limit){
                    ans = Math.max(ans,j-i);
                    j++;
                    continue;
                }
                
                else{
                    break;
                }
                
            }
            i++;
        }
        return ans+1;
    }
    
}