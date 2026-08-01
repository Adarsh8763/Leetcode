class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);

        while(n != 1){
            int sum = 0;
            while(n>0){
                int rem = n%10;
                sum += Math.pow(rem, 2);
                n = n/10;
            }
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
            n = sum;
        }
        return true;
    }
}