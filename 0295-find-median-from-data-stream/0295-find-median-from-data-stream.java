class MedianFinder {
    PriorityQueue<Integer> minr;
    PriorityQueue<Integer> maxl;

    public MedianFinder() {
        minr = new PriorityQueue<>();
        maxl = new PriorityQueue<>(Collections.reverseOrder());

    }
    
    public void addNum(int num) {
        if(maxl.size()==0 || num<maxl.peek()){
            maxl.add(num);
        }
        else{
            minr.add(num);
        }
        if(maxl.size()-minr.size()>1){
            minr.add(maxl.poll());
        }
        else if(minr.size()>maxl.size()){
            maxl.add(minr.poll());
        }
    }
    
    public double findMedian() {
        if(maxl.size()==minr.size()){
            return ((maxl.peek())+(minr.peek()))/2.0;
        }
        else{
            return maxl.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */