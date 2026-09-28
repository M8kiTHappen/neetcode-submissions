class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());

        if(maxHeap.size() > minHeap.size()){
            minHeap.add(maxHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
             return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else{
            
            return minHeap.peek();
        
        }
    }
}
