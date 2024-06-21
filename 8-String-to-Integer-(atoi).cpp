class Solution {
public:
    int myAtoi(string s) {
        bool spacesIgnored=false, signPassed=false;
        int n=0, sign=1;
        vector <int> nums;

        for (char c : s){
            if ('0'<=c && c<='9'){
                spacesIgnored=signPassed=true;
                nums.push_back(c-'0');
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

        for (int i=nums.size()-1; i>=0; i--)
        {
            if (n+nums[i]*pow(10,nums.size()-1-i)>INT_MAX){
                n = sign==1 ? INT_MAX : INT_MIN;
                return n;
            }
            else n += nums[i]*pow(10,nums.size()-1-i);
        }
        
        return n*sign;
    }
};