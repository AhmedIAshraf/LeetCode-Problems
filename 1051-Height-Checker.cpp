class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int> exp = heights;
        sort(heights.begin(),heights.end());
        
        int r=0;
        for(int i=0;i<exp.size();i++){
            if(exp[i]!=heights[i]) r++;
        }
        return r;
    }
};