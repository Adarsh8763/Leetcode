class Solution {
    public int calPoints(String[] operations) {
        List<Integer> record = new ArrayList<>();
        
        for(String operation : operations){
            int idx = record.size()-1;
            if(operation.equals("C")){
                record.remove(record.get(idx));
            }
            else if(operation.equals("D")){
                record.add(record.get(idx)*2);
            }
            else if(operation.equals("+")){
                int num1 = record.get(idx-1);
                int num2 = record.get(idx);
                record.add(num1+num2);
            }
            else{
                record.add(Integer.parseInt(operation));
            }
        }

        int score = 0;
        for(int num : record){
            score += num;
        }

        return score;
    }
}