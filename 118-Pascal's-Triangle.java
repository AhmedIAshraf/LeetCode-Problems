class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        int i = 0;

        while(numRows > 1){
            int n = ans.get(i).size();
            List<Integer> next = new ArrayList<>();
            next.add(1);
            
            for (int j=0; j<n-1; j++){
                next.add(ans.get(i).get(j) + ans.get(i).get(j+1));
            }
            next.add(1);
            ans.add(next);
            i++;
            numRows--;
        }

        return ans;
    }
}