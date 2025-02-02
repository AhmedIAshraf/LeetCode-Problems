class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;
        for (int i=n-2; i>=0; i--){
            if (nums[i] == 0){
                int j = i-1;
                while (j >= 0 && nums[j] + j <= i)
                    j--;
                if (j < 0)
                    return false;
            }
        }
        return true;
    
    }
}