class RandomizedSet {

    Map<Integer,Integer> valuesToIndex;

    List<Integer> values;

    Random random;

    public RandomizedSet() {
        valuesToIndex = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(valuesToIndex.containsKey(val)) return false;
        valuesToIndex.put(val,values.size());
        values.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valuesToIndex.containsKey(val)) return false;
        int i = valuesToIndex.get(val);
        if(i != values.size()-1){
            values.set(i, values.get(values.size()-1));
            valuesToIndex.put(values.get(values.size()-1),i);
        }
        values.remove(values.size()-1);
        valuesToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */