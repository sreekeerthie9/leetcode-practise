import java.util.*;
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        long res = (bs(nums,n,right) - bs(nums,n,left-1))%1000000007;
        return (int)(res+1000000007)%1000000007;
    }
    static long bs(int nums[],int n,int k){
        int lo = Arrays.stream(nums).min().getAsInt();
        int hi = Arrays.stream(nums).sum();
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(countAndSum(nums,n,mid).getKey()>=k){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        Map.Entry<Integer,Long> result = countAndSum(nums,n,lo);
        return result.getValue()-lo*(result.getKey()-k);

    }
    static Map.Entry<Integer,Long> countAndSum(int nums[],int n,int target){
        int count = 0;
        long cs = 0;
        long ws = 0;
        long ts = 0;
        for(int j=0,i=0;j<n;j++){
            cs+=nums[j];
            ws+=nums[j]*(j-i+1);
            while(cs>target){
                ws-=cs;
                cs-=nums[i++];
            }
            count+=j-i+1;
            ts+=ws;
        }
        return new AbstractMap.SimpleEntry<>(count,ts);
    }
    }