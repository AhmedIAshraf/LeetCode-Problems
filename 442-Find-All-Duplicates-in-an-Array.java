import java.util.Hashtable;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        int n = nums.length;
        boolean[] exists = new boolean[n+1]; 
        List<Integer> dups = new ArrayList<>();

        for(int i=0; i<n; i++){
            if (exists[nums[i]]){
                dups.add(nums[i]);
            }
            else {
                exists[nums[i]] = true;
            }
        }

        return dups;
    }
}