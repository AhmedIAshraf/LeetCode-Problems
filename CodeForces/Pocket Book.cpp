#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <vector>
#include <queue>
#include <deque>
#include <stack>
#include<iterator>
#define PI 3.14159265359
using namespace std;

int main(){

    int n,m; cin>>n>>m;
    unsigned long long result=1;
    vector <string> v(n);
    for (int i=0; i<n; i++) cin>>v[i];

    for (int i=0;i<m;i++){
        int letters[26]={0}, distinctLetters=0;
        for (string s : v){
            if (!letters[s[i]-'A']){
                distinctLetters++;
                letters[s[i]-'A']=1;
            }
        }
        result *= distinctLetters;
        result %= 1000000007;
    }

    cout<<result<<endl;
}

