class Solution {
    public void sortColors(int[] nums) {
        
        int n = nums.length;
        int l=-1;

        // Sorting twos only
        for (int i=0; i<n; i++){
            if (nums[i] < 2){
                l++;
                swap(nums, l, i);
            }
        }

        // Sorting zeros and ones only
        l = -1;
        for (int i=0; i<n; i++){
            if (nums[i] < 1){
                l++;
                swap(nums, l, i);
            }
            else if (nums[i] == 2){
                break;
            }
        }

        // Another solution: Frequency array then overrite the original one
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}