class Solution {
public:

    string reverse(string s, int l, int r){
        for (int i=l;i<=(l+r)/2;i++){
            char t=s[i];
            s[i]=s[r+l-i];
            s[r+l-i]=t;
        }
        return s;
    }

    string reverseParentheses(string s) {
        stack<char> stq;
        vector<int> rightBrackets;
        for (int i=0;i<s.length();i++){ 
            if(s[i]=='(') rightBrackets.push_back(i);
            else if (s[i]==')'){
                int n = rightBrackets.size();
                s[rightBrackets[n-1]] = s[i] =  ' ';
                 s = reverse(s,rightBrackets[n-1],i-1);
                rightBrackets.erase(rightBrackets.end()-1, rightBrackets.end());
            }
        }
        s.erase(remove_if(s.begin(), s.end(), ::isspace), s.end());
        return s;
    }
};
