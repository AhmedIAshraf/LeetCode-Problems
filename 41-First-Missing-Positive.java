import java.util.Hashtable;

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        int next = 1;
        Hashtable<Integer, Boolean> exists = new Hashtable<>();
        
        for (int i=0; i<n; i++){
            if (nums[i] == next){
                next++;
            }
            else if (nums[i] > 0){
                exists.put(nums[i], true);
            }
        }

        while(exists.containsKey(next)){
            next++;
        }

        return next;
    }
}