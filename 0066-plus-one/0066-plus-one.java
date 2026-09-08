class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        if(digits[n-1] != 9){
            digits[n-1] += 1;
            return digits;
        }
        boolean willExceed = false;
        for(int i=n-1; i>=0; i--){
            if(digits[i] == 9){
                willExceed = true;
            }
            else{
                willExceed = false;
                break;
            }
        }

        if(willExceed == false){
            for(int i=n-1; i>=0; i--){
                if(digits[i] == 9){
                    digits[i] = 0;
                }
                else{
                    digits[i]++;
                    break;
                }
            }
            return digits;
        }

        int[] newNum = new int[n+1];
        newNum[0] = 1;

        return newNum;
    }
}