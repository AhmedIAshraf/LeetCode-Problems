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

int n;
vector<int> dp(n+1);

int dfs (vector<int> g, int i){
    int r=1;
    if (dp[i]) return dp[i];
    if (g[i] != -1) r+=dfs(g, g[i]);
    return dp[i]=r;
}
//The Idea is to get the longest sequence of superiors as in any sequence its elements must be separated so
//the min # of groups will be # of elements in the longest seq (each of them in a group with other elements from other sequences)

int main(){
    cin>>n;
    vector<int> g(n+1);    
    for (int i=1;i<=n;i++)cin>>g[i], dp.push_back(0);

    int maxLen=0;
    for (int i=n;i>0;i--){
        if (g[i]!=-1) maxLen = max(maxLen, dfs(g, i));
        else maxLen = max(maxLen, 1);
    }

    cout<<maxLen<<endl;
    return 0;
}
