import java.util.Hashtable;

class Solution {;

    Hashtable<Integer, Integer> table = new Hashtable<>();
    
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for (int i=0;i<nums.length;i++){
            if (i!=0) nums[i]+=nums[i-1];
            if (nums[i]==k) count++;
            if (table.containsKey(nums[i]-k))
                count+=table.get(nums[i]-k);

            if (table.containsKey(nums[i]))
                table.replace(nums[i],table.get(nums[i])+1);
            else table.put(nums[i],1);
        }
        return count;
    }
}