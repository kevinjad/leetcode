class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length%groupSize != 0) return false;
        Map<Integer,Integer> map = new TreeMap<>();
        for(int val : hand){
            map.put(val, map.getOrDefault(val,0)+1);
        }
        for(int i : map.keySet()){
            int count = map.get(i);
            if (count == 0) continue;
            for(int j = i;j<i+groupSize;j++){
                Integer c = map.get(j);
                if(c == null || c < count) return false;
                map.put(j,c-count);
            }
        }
        return true;
    }
}