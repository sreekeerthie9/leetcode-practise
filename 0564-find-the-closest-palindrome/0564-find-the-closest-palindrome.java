class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        int i = len%2==0?len/2-1:len/2;
        long fh = Long.parseLong(n.substring(0,i+1));
        List<Long> p = new ArrayList<>();
        p.add(halftopalindrome(fh,len%2==0));
        p.add(halftopalindrome(fh+1,len%2==0));
        p.add(halftopalindrome(fh-1,len%2==0));
        p.add((long)Math.pow(10,len-1)-1);
        p.add((long)Math.pow(10,len)+1);

        long diff = Long.MAX_VALUE;
        long res = 0;
        long n1 = Long.parseLong(n);
        for(long num : p){
            if(num == n1){
                continue;
            }
            if(Math.abs(num-n1)<diff){
                diff = Math.abs(num-n1);
                res = num;
            }
            else if(Math.abs(num-n1)==diff){
                res = Math.min(res,num);
            }
        }
        return String.valueOf(res);
    }
    static long halftopalindrome(long fh,boolean even){
        long res = fh;
        if(!even){
            fh = fh/10;
        }
        while(fh>0){
            res = res*10+(fh%10);
            fh/=10;
        }
        return res;
    }
}