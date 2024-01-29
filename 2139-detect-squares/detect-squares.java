class DetectSquares {

    Map<String, Integer> memory;

    public DetectSquares() {
        memory = new HashMap<>();
    }

    public void add(int[] point) {
        memory.put(point[0]+"@"+point[1], memory.getOrDefault(point[0]+"@"+point[1], 0)+1);
    }

    public int count(int[] point) {
        int count = 0;
        for(Map.Entry<String,Integer> e : memory.entrySet()){
            String[] val = e.getKey().split("@");
            int p1 = Integer.parseInt(val[0]);
            int p2 = Integer.parseInt(val[1]);

            if(Math.abs(p1-point[0]) == Math.abs(p2-point[1])){
                if(p1 == point[0] && p2 == point[1]) continue;
                if(memory.containsKey(p1+"@"+point[1]) && memory.containsKey(point[0]+"@"+p2)){
                    int v1 = e.getValue();
                    int v2 = memory.get(p1+"@"+point[1]);
                    int v3 = memory.get(point[0]+"@"+p2);
                    count += (v1*v2*v3);
                }
            }
        }
        return count;
    }
}
/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */