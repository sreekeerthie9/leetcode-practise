class Solution {
    public int findJudge(int n, int[][] trust) {
        int a[] = new int[n+1];
        int b[] = new int[n+1];
        for(int i=0;i<trust.length;i++){
            int pa = trust[i][0];
            int pb = trust[i][1];
            a[pa]++;
            b[pb]++;
        }
        for(int i=1;i<=n;i++){
            if(a[i]==0 && b[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}