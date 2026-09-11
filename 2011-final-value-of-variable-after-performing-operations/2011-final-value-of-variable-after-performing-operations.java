class Solution {
    public int finalValueAfterOperations(String[] operations) {

        // ====== My approach ======
        // int x = 0;
        // for(String str : operations){
        //     if(str.equals("--X") || str.equals("X--")){
        //         x--;
        //     }
        //     else{
        //         x++;
        //     }
        // }
        // return x;

        // ====== Most Optimal =====
        int x = 0;
        for(String str : operations){
            if(str.charAt(1) == '-'){
                x--;
            }
            else{
                x++;
            }
        }
        return x;
    }
}