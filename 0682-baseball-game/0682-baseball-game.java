class Solution {
    public int calPoints(String[] operations) {
        // List<Integer> record = new ArrayList<>();
        
        // for(String operation : operations){
        //     int idx = record.size()-1;
        //     if(operation.equals("C")){
        //         record.remove(record.get(idx));
        //     }
        //     else if(operation.equals("D")){
        //         record.add(record.get(idx)*2);
        //     }
        //     else if(operation.equals("+")){
        //         int num1 = record.get(idx-1);
        //         int num2 = record.get(idx);
        //         record.add(num1+num2);
        //     }
        //     else{
        //         record.add(Integer.parseInt(operation));
        //     }
        // }

        // int score = 0;
        // for(int num : record){
        //     score += num;
        // }

        // return score;

        Stack<Integer> record = new Stack<>();

        for(String operation : operations){
            if(operation.equals("C")){
                record.pop();
            }
            else if(operation.equals("D")){
                int prev = record.peek();
                record.push(2*prev);
            }
            else if(operation.equals("+")){
                int num1 = record.pop();
                int num2 = record.peek();
                record.push(num1);
                record.push(num1+num2);
            }
            else{
                record.push(Integer.parseInt(operation));
            }
        }

        int score = 0;
        while(!record.isEmpty()){
            score += record.pop();
        }

        return score;
    }
}