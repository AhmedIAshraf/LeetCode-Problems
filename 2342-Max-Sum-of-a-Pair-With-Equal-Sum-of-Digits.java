import java.util.Hashtable; 
import java.util.Collections;

class Solution {
    public int maximumSum(int[] nums) {
        
        Hashtable <Integer, Integer> sumOfDigitsTable = new Hashtable<>();
        int maxSum=0;
        int n=nums.length;

        for (int i=n-1; i>=0; i--){
            int temp = nums[i];
            int sum = 0;
            while(temp > 0){
                sum += temp%10;
                temp /= 10;
            }
            if (sumOfDigitsTable.containsKey(sum)){
                int existingNumber = sumOfDigitsTable.get(sum);
                maxSum = Math.max(maxSum, nums[i] + existingNumber);
                if (nums[i] > existingNumber) 
                    sumOfDigitsTable.put(sum, nums[i]);
            }
            else sumOfDigitsTable.put(sum, nums[i]);
        }

        return maxSum > 0 ? maxSum : -1;

    }
}