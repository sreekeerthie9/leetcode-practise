class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int l = n*(n+1)/2;
        int ar[] = new int[l];
        int k=0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                ar[k] = sum;
                k++;
            }
        }
        Arrays.sort(ar);
        int sum = 0;
        for(int i=left-1;i<=right-1;i++){
            sum = (sum+ar[i])%1000000007;
        }
        return sum;
    }
}