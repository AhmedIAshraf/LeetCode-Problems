class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        long long waiting=0;
        int curr=customers[0][0]+customers[0][1];
        waiting+=customers[0][1];
        
        for (int i=1;i<customers.size();i++){
            if (curr>customers[i][0]) waiting+=(curr-customers[i][0]);
            else curr=customers[i][0];
            waiting+=customers[i][1];
            curr+=customers[i][1];
        }

        return ((long double)waiting/customers.size());
    }
};