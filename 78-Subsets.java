class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());
        int n = nums.length;

        for(int i=0; i<n; i++){
            int m = powerSet.size();
            for(int j=0; j<m; j++){
                powerSet.add(new ArrayList<>(powerSet.get(j)));
                powerSet.get(m+j).add(nums[i]);
            }
        }

        return powerSet;

    }
}