class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int smallestNonNineIdx = -1;
        
        for (int i=n-1; i>-1; i--){
            if (digits[i] != 9){
                smallestNonNineIdx = i;  
                break;
            }
        }

        if(smallestNonNineIdx == -1){
            int[] ans = new int[n+1];
            ans[0] = 1;
            return ans;
        } 
        else{
            for (int i=n-1; i>smallestNonNineIdx; i--){
                digits[i] = 0;
            }
            digits[smallestNonNineIdx]++;
            return digits;
        }

    }
}