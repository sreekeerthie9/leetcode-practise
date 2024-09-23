class Solution {
    static int SP(String s,HashSet<String> set,int idx,int n,int dp[]){
        if(idx==n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        
        int ans = SP(s,set,idx+1,n,dp)+1;
        for(int i=idx;i<n;i++){

            if(set.contains(s.substring(idx,i+1))){
                ans = Math.min(ans,SP(s,set,i+1,n,dp));
                
            }
        }
        return dp[idx] = ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        for(String str:  dictionary){
            set.add(str);
        }
        
        int res = SP(s,set,0,n,dp);
        return res;
    }
}