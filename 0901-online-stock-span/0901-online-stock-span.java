class StockSpanner {
    Stack<Integer> stack;
    List<Integer> prices;

    public StockSpanner() {
        stack = new Stack<>();
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        prices.add(price);
        int currIdx = prices.size() - 1;

        while(!stack.isEmpty() && prices.get(stack.peek()) <= price){
            stack.pop();
        }
        
        int idxOfPrevLarge = stack.isEmpty() == true ? -1 : stack.peek();
        int noOfPrevSmaller = currIdx - idxOfPrevLarge;

        stack.push(currIdx);

        return noOfPrevSmaller;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */