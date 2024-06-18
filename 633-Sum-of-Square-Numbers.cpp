class Solution {
public:
    bool judgeSquareSum(int c) {
        // if (c==0 || c==1 || (int)sqrt(c)==sqrt(c)) return true;
        for (int i=(int)sqrt(c); i>=0; i--){
            int n=c-(i*i);
            if ((int)sqrt(n)==sqrt(n)) return true;
        }
        return false;
    }
};