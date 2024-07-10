class Solution {
public:
    int minOperations(vector<string>& logs) {
        int n=0;
        for (string s : logs){
            if (s=="./") continue;
            else if (s=="../"){
                if (n>0) n--;
            }
            else n++;
        }
        return n;
    }
};