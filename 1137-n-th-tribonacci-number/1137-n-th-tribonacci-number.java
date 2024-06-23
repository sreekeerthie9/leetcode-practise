class Solution {
    public int tribonacci(int n) {
        int tri[] = new int[4];
        tri[0] = 0;
        if(n>0){
            tri[1] = 1;
        }
        
        if(n>1){
            tri[2] = 1;
        }
        
        for(int i=3;i<=n;i++){
            tri[i%4] = tri[(i-1)%4]+tri[(i-2)%4]+tri[(i-3)%4];
        }
        return tri[n%4];
    }
}