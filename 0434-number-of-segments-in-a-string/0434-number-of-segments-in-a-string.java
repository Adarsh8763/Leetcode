class Solution {
    public int countSegments(String s) {
        if(s.length() == 0) return 0;

        boolean flag = true;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                flag = true;
                continue;
            }
            if(flag == true){
                flag = false;
                count++;
            }
        }

        return count;
    }
}