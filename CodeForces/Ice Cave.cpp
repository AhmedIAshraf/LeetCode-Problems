#include <iostream>
#include <cstring>
#include <string.h>
#include <cmath>
#include <algorithm>
#include <vector>
#include <queue>
#include <deque>
#include <stack>
#include<iterator>
#define PI 3.14159265359
using namespace std;

int n,m;
int r,c;
bool targetAlreadyCracked=false;
vector<string> g;
vector<vector<bool>> visited;

bool dfs(int i, int j){

    if (r-1==i && c-1==j){
        if (g[i][j]=='X') targetAlreadyCracked=1;
        return 1;
    }
    if (visited[i][j] || g[i][j]=='X') return 0;
    visited[i][j]=1;

    bool ans=false;
    if (abs(i-(r-1))+abs(j-(c-1))==1) ans=ans||dfs(r-1, c-1);
    if (j>0 && !ans) ans=ans||dfs(i,j-1);
    if (j<m-1 && !ans) ans=ans||dfs(i,j+1);
    if (i>0  && !ans) ans=ans||dfs(i-1,j);
    if (i<n-1 && !ans) ans=ans||dfs(i+1,j);

    if(ans) g[i][j]='X';
    return ans;
}

int main(){

    cin>>n>>m;
    for (int i=0;i<n;i++){
        string s; cin>>s;
        g.push_back(s);
        vector<bool> v(m,0);
        visited.push_back(v);
    }

    int r1,c1; cin>>r1>>c1;
    g[r1-1][c1-1]='.';
    cin>>r>>c;
    bool ans=dfs(r1-1, c1-1);

    if (targetAlreadyCracked) cout<<"YES";
    else if (ans){
        bool neighbor=0;
        int i=r-1, j=c-1;
        if (i>0 && g[i-1][j]=='.') neighbor=1;
        if (i<n-1 && g[i+1][j]=='.') neighbor=1;
        if (j>0 && g[i][j-1]=='.') neighbor=1;
        if (j<m-1 && g[i][j+1]=='.') neighbor=1;
        string out = ans&&neighbor ? "YES" : "NO";
        cout<<out;
    }
    else cout<<"NO";
}
