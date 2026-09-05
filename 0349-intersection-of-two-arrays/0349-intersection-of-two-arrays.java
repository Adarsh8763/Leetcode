class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ansSet = new HashSet<>();

        for(int num1 : nums1){
            set.add(num1);
        }

        for(int num2 : nums2){
            if(set.contains(num2)){
                ansSet.add(num2);
            }
        }
        
        int[] res = new int[ansSet.size()];
        int i = 0;
        for(int val : ansSet){
            res[i] = val;
            i++;
        }

        return res;
    }
}