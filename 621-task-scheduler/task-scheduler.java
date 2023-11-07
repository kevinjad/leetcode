class Solution {
    public int leastInterval(char[] tasks, int n) {
        //-- q
        // A3 B3  -
        //B3   A2,3
        Map<Character,Integer> map = new HashMap<>();
        for(char c : tasks){
            int val = map.getOrDefault(c,0);
            map.put(c, val+1);
        }
        Queue<Pa> queue = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(map.values());
        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int val = maxHeap.poll();
                val--;
                if(val > 0){
                    Pa pa = new Pa(val,time+n);
                    queue.add(pa);
                }
            }

            if(!queue.isEmpty()){
                Pa pa = queue.peek();
                if(pa.v2 <= time){
                    queue.poll();
                    maxHeap.add(pa.v1);
                }
            }
        }
        return time;
    }
}

class Pa{
    int v1;
    int v2;

    public Pa(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
}

