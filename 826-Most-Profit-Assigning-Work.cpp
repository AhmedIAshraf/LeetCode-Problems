#include <unordered_map> 
class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        sort (worker.begin(), worker.end());
        unordered_map <int, int> table;
        for (int i=0; i<profit.size(); i++){
            int ii = difficulty[i]; 
            table[ii] = max(profit[i],table[ii]);
        }
        sort (difficulty.begin(), difficulty.end());

        int diff=0, mx=0, ind=0, r=0;
        for (int i=0; i<worker.size(); i++){
            while(ind<profit.size() && difficulty[ind]<=worker[i]){
                if (table[difficulty[ind]]>mx){
                    mx=table[difficulty[ind]];
                    diff=difficulty[ind];
                }
                ind++;
            }
            r+= mx;
        }
        return r;
    }
};










