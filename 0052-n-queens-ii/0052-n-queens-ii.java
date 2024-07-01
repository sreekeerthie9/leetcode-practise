class Solution {
    static boolean canplace(int vis[],int row,int col){
        for(int i=0;i<row;i++){
            if(vis[i]==col || Math.abs(vis[i]-col)==Math.abs(i-row)){
                return false;
            }
        }
        return true;
    }
    static void bt(int n,int row,int vis[],List<int[]> li){
        if(row==n){
           int[] copy = new int[n];
            System.arraycopy(vis, 0, copy, 0, n);
            li.add(copy);
            return;

        }
        for(int col = 0;col<n;col++){
            if(canplace(vis,row,col)){
                vis[row] = col;
                bt(n,row+1,vis,li);
                vis[row] = -1;
            }
        }
    }
    public int totalNQueens(int n) {
        int vis[] = new int[n];
        List<int[]> li = new ArrayList<>();
        Arrays.fill(vis,-1);
        bt(n,0,vis,li);
        return li.size();
    }
}