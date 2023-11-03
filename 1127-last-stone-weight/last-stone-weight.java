class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones) priorityQueue.add(s);
        while(priorityQueue.size() > 1){
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            if (x == y) continue;
            priorityQueue.add(x-y);
        }
        if(priorityQueue.isEmpty()) return 0;
        return priorityQueue.poll();
    }
}