#include <unordered_map> 
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        unordered_map <int, int> table;
        vector<int> extra,res;
        for (int i:arr2) table[i]=1;
        for (int i:arr1) {
            if (table[i]==0) extra.push_back(i);
            else table[i]++;
        }
        for (int i:arr2) {
            vector<int> v(table[i]-1,i);
            res.insert(res.end(),v.begin(),v.end());
        }
        sort(extra.begin(),extra.end());
        res.insert(res.end(),extra.begin(),extra.end());
        return res;
    }
};