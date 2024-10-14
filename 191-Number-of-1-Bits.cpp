class Solution {
public:
    int hammingWeight(int n) {
        int m=0;
        while(n){
            m += (n%2);
            n /=2 ;
        }
        return m;
    }
};