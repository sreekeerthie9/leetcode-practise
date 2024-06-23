class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<=i+nums[i] && j<n;j++){
                dp[j] = Math.min(dp[j],dp[i]+1);
            }
            
        }
        return dp[n-1];
    }
}