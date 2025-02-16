import java.util.Hashtable;
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        Hashtable<Integer, Integer> exists = new Hashtable<>();

        for (int i=0; i<n; i++){
            if (exists.containsKey(target - nums[i])){
                return new int[]{i, exists.get(target-nums[i])};
            }
            exists.put(nums[i], i);
        }

        return new int[0];    
    }
}