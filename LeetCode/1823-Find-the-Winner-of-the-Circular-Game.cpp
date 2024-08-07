class Solution {
public:
    int findTheWinner(int n, int k) {
        vector<int> v(n);
        for (int i=0;i<n;i++) v[i]=i+1;

        int i=0;
        while(v.size()>1){
            i+=((k-1)%v.size());
            i%=v.size();
            v.erase(v.begin()+i);
        }
        return v[0];
    }
};