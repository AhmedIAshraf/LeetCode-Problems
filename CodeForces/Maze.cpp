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

int n,m,k;
vector<string> g;
vector<vector<bool>> visited;

bool dfs(int i, int j){

    if(visited[i][j]) return false;
    if(k==0) return true;
    visited[i][j]=1;

    bool endPoint=false;
    if (i<n-1 && g[i+1][j]=='.') endPoint=endPoint||dfs(i+1, j);
    if (i>0 && g[i-1][j]=='.') endPoint=endPoint||dfs(i-1, j);
    if (j<m-1 && g[i][j+1]=='.') endPoint=endPoint||dfs(i, j+1);
    if (j>0 && g[i][j-1]=='.') endPoint=endPoint||dfs(i, j-1);

    if(!endPoint && k>0){
        g[i][j]='X';
        k--;
        return false;
    }

    return (endPoint);

}

int main(){

    cin>>n>>m>>k;

    for (int i=0;i<n;i++){
        string s; cin>>s;
        g.push_back(s);
        vector<bool> v(m,0);
        visited.push_back(v);

    }

    for (int i=0;i<n;i++){
        for (int j=0;j<m;j++){
            if (!visited[i][j] && g[i][j]=='.'){
                dfs(i, j);
                break;
            }
        }
    }

    for (string s : g) cout<<s<<endl;
}
