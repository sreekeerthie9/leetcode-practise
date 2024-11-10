class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 1;
        int right = nums.length;
        int min = -1;

        while(left<=right){
            int mid = left + (right - left)/2;
            if(valid(nums,k,mid)){
                min = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return min;
    }

    private boolean valid(int[] nums, int k, int mid){
        int[] bitCount = new int[32];

        for(int right = 0;right<nums.length;right++){
            updatedBitCount(bitCount, nums[right], 1);

            if(right >= mid){
                updatedBitCount(bitCount, nums[right-mid],-1);
            }

            if(right >= mid-1 && convertToNumber(bitCount)>=k){
                return true;
            }
        }
        return false;
    }

    private void updatedBitCount(int[] bitCount, int number, int x){
        for(int bit = 0; bit<32;bit++){
            if(((number>>bit)&1) != 0){
                bitCount[bit]+=x;
            }
        }
    }

    private int convertToNumber(int[] bitCount){
        int number = 0;
        for(int bit=0;bit<32;bit++){
            if(bitCount[bit] !=0){
                number|=1<<bit;
            }
        }
        return number;
    }
}