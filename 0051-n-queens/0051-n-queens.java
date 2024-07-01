class Solution {
    private static boolean canplace(int placed[],int c,int r){
        for(int i=0;i<r;i++){
            if(placed[i]==c || Math.abs(placed[i]-c)==Math.abs(i-r)){
                return false;
            }
        }
        return true;
    }
    static void nq(int n,int idx,int placed[],List<List<String>> ans){
        if(idx==n){
            List<String> li = new ArrayList<>();
            for(int i=0;i<n;i++){
                String str = "";
                for(int j=0;j<n;j++){
                    if(placed[i]==j){
                        str+="Q";
                    }
                    else{
                        str+=".";
                    }
                }
                li.add(str);
            }
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=0;i<n;i++){
            if(canplace(placed,i,idx)){
                placed[idx] = i;
                nq(n,idx+1,placed,ans);
                placed[idx] = -1; 
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int placed[] = new int[n];
        Arrays.fill(placed,-1);
        nq(n,0,placed,ans);
        return ans;
    }
}