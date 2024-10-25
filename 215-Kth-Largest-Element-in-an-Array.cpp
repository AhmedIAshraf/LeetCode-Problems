class Solution {
public:

    int partition (vector<int>& nums, int l, int r, int idx){
        int ptr=l;
        int piv = nums[idx];
        swap(nums[ptr++], nums[idx]);
        for (int i=l; i<r; i++){
            if (nums[i] < piv)
                swap(nums[i], nums[ptr++]);
        }
        swap(nums[l], nums[ptr-1]);
        return ptr-1;
    }

    int getKthElement(vector<int>& nums, int l, int r, int k){
        if (l==r)
            return nums[l];

        int pivIdx = (rand() % (r-l));
        if (pivIdx < l) pivIdx += l;
        int piv = nums[pivIdx];
        int truePivIdx = partition(nums, l, r, pivIdx);

        if (k == truePivIdx)
            return nums[k];
        else if (k>truePivIdx)
            return getKthElement(nums, truePivIdx+1, r, k);
        else
            return getKthElement(nums, l, truePivIdx, k);
    }

    int findKthLargest(vector<int>& nums, int k) {
        return getKthElement(nums, 0, nums.size(), nums.size()-k);
    }
};