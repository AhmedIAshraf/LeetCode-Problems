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

int uncolored=0,W=0,B=0;
int totalW=0, totalB=0;
pair<int,int> p = {0,-1};
vector<pair<bool,int>> vis(101,p);        //first=visited of not, second=color(-1 can't be colored, 0 white and 1 black)

void dfs(vector<vector<int>> g, int i){
        bool black=false, white=false;
        vis[i].first=true;

        for (int k : g[i]){
            int color = vis[k].second;
            if (color==1) black=true;
            else if (color==0) white=true;
        }

        if (black && white) return;
        else if (white&&!black || W>=B) vis[i].second=1, B++;
        else if (!white&&black || B>W) vis[i].second=0, W++;

        for (int k : g[i]){
            if (!vis[k].first) dfs(g, k);
        }

}

int main(){

    int n,m; cin>>n>>m;
    vector<vector <int>> g(n+1);

    for (int i=0;i<m;i++){
        int a,b; cin>>a>>b;
        vector<int> v;
        g[b].push_back(a);
        g[a].push_back(b);
    }

    for (int i=1;i<=n;i++){
        if(!vis[i].first){
            W=B=0;
            vis[i].second=1;
            dfs(g, i);
            if (totalB>=totalW){
                totalB+=min(W, B);
                totalW+=max(W, B);
            }
            else{
                totalW+=min(W, B);
                totalB+=max(W, B);
            }
        }
    }

    int ans=n-2*min(totalW, totalB);
    cout<<ans<<endl;

}
