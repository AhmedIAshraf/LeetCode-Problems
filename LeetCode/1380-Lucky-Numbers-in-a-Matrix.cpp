class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        vector<int> mins,maxs;
        vector<int> ans;
        int idx=0;
        for (int i=0;i<matrix.size();i++){
            mins.push_back(*min_element(matrix[i].begin(), matrix[i].end()));
        }
        for (int j=0;j<matrix[0].size();j++){
            int mx=INT_MIN;
            for (int i=0;i<matrix.size();i++){
                mx = max (mx, matrix[i][j]);
            }
            if (find(mins.begin(), mins.end(),mx)!=mins.end()) ans.push_back(mx);
        }
        return ans;
    }
};