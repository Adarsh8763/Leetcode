class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        list.add(val);    
        map.put(val, list.size()-1);

        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int valIdx = map.get(val);
        int lastIdx = list.size()-1;
        int lastVal = list.get(lastIdx);
        
        if(lastVal != val){
            map.put(lastVal, valIdx);

            // Put last element where val was
            list.set(valIdx, lastVal);
        }

        map.remove(val);
        list.remove(list.size()-1);

        return true;
    }
    
    public int getRandom() {
        int size = list.size();
        int rand = (int)(Math.random() * size);
        return list.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */