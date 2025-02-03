class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        int countInc=0, countDec=0;
        int maxInc=0, maxDec=0;
        int n = nums.length;

        for (int i=0; i<n; i++){
            if (i==0 || nums[i] == nums[i-1]){
                countInc = countDec = 1;
            }
            else if (nums[i] > nums[i-1]){
                countInc++;
                countDec = 1; 
            }
            else if (nums[i] < nums[i-1]){
                countDec++;
                countInc = 1; 
            }
            maxDec = Math.max(maxDec, countDec);
            maxInc = Math.max(maxInc, countInc);
        }

        return Math.max(maxDec, maxInc);

    }
}