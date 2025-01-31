class Solution {
    public int removeDuplicates(int[] nums) {
        int l=1, r=2;
        int n = nums.length;
        if (n<2) return n;
        
        while(l<n && nums[l] != nums[l-1]) l++;
        if (l==n) return l;
        r = l+1;
        int max = nums[l];
        
        while(r<n && l<r){
            while(r<n && nums[r] <= max) r++;
            if (r>=n) return l;
            swap(nums, l, r);
            max = nums[l];
            l++;
            r++;
        }
        return l;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
}
