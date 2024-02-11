class MedianFinder {

    // 4 3 2 1
    // 4 - 
    // 3 - 4
    // 2 - 3 4

    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> bigHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Comparator.reverseOrder());
        bigHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if(smallHeap.size()-bigHeap.size() >= 2){
            bigHeap.add(smallHeap.poll());
        }
        if(smallHeap.size()>0 && bigHeap.size()>0 && smallHeap.peek() > bigHeap.peek()){
            bigHeap.add(smallHeap.poll());
        }
        if(smallHeap.size()>0 && bigHeap.size()>0 && bigHeap.size()-smallHeap.size() >= 2){
            smallHeap.add(bigHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size() == bigHeap.size()){
            return ((double) (smallHeap.peek()+ bigHeap.peek()))/2;
        } else {
            if(smallHeap.size() > bigHeap.size()) return smallHeap.peek();
            else return bigHeap.peek();
        }
    }
}