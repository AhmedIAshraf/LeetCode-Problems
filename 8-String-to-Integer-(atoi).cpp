class Solution {
public:
    int myAtoi(string s) {
        bool spacesIgnored=false, signPassed=false;
        int n=0, sign=1;

        for (char c : s){
            if ('0'<=c && c<='9'){
                spacesIgnored=signPassed=true;
                if ( (long)n*10 + (c-'0') > INT_MAX){
                    n = sign==1 ? INT_MAX : INT_MIN;
                    return n;
                }
                else n = n*10 + (c-'0');
            }
            else if (c=='-' && !signPassed) {
                spacesIgnored= signPassed= true;
                sign = -1;
            }
            else if (c=='+' && !signPassed) {
                spacesIgnored= signPassed= true;
            }
            else if (c==' ' && !spacesIgnored) continue;
            else break;
        }
        
        return n*sign;
    }
};