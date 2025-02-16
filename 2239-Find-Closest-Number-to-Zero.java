class Solution {
    public int findClosestNumber(int[] nums) {
        int num = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++){
            if (Math.abs(nums[i]) < Math.abs(num)){
                num = nums[i];
            }
            else if (num == -nums[i]){
                num = Math.max(num, nums[i]);
            }
        }
        return num;
    }
}