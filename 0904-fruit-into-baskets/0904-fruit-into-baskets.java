class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0;
        int maxFruits = 0;

        HashMap<Integer, Integer> basket = new HashMap<>();

        for(right=0; right<fruits.length; right++){
            int currCount = basket.getOrDefault(fruits[right], 0);
            basket.put(fruits[right], currCount+1);

            while(basket.size() > 2){
                int fruitCount = basket.get(fruits[left]);
                if(fruitCount == 1){
                    basket.remove(fruits[left]);
                }
                else{
                    basket.put(fruits[left], fruitCount-1);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right-left+1);
        }
        return maxFruits;
    }
}