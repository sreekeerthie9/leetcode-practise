class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max = 0;
        //int maxind = 0;
        int sum = 0;
        int actsum = 0;
        for(int i=0;i<grumpy.length;i++){
            if(grumpy[i]==0){
                actsum+=customers[i];
            }
        }
        int temp = 0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i]==0){
                temp+=customers[i];
            }
            sum+=customers[i];
        }
        actsum = actsum-temp+sum;
        if(actsum>max){
            max = actsum;
            //maxind = 0;
        }
        for(int i=minutes;i<customers.length;i++){
            actsum = actsum+customers[i]-customers[i-minutes];
            if(grumpy[i]==0){
                actsum-=customers[i];
            }
            if(grumpy[i-minutes]==0){
                actsum+=customers[i-minutes];
            }
            //actsum+=sum;
            if(actsum>max){
                max = actsum;
                //maxind = i-minutes+1;
            }
        }
        

        return max;
    }
}