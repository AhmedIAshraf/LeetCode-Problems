class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        int n = nums.length;
        int max = 1;
        int l=-1;
        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            l = i-1;
            int temp = k;
            int curr = nums[i];
            
            while(i<n && nums[i]==curr){
                i++;
            }
            while(temp>0 && l>=0){
                temp -= (curr - nums[l]);
                l--;
            }
            i--;

            int compare = i - l;
            if (temp < 0){
                compare--;
            }
            max = Math.max(max, compare);
        }

        return max;
    }
}