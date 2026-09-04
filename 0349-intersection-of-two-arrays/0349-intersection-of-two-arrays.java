class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int num1 : nums1){
            set.add(num1);
        }

        for(int num2 : nums2){
            if(set.contains(num2)){
                list.add(num2);
            }
        }
        
        set.clear();

        for(int val : list){
            set.add(val);
        }

        list.clear();

        for(int val : set){
            list.add(val);
        }

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}