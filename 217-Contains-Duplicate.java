import java.util.Hashtable;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Hashtable<Integer, Boolean> table = new Hashtable<>();
        int n = nums.length;
        for (int i=0; i<n; i++){
            if (table.containsKey(nums[i]))
                return true;
            table.put(nums[i], true);
        }
        return false;
    }
}