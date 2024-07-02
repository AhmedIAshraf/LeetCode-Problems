#include <iostream>
#include <cstring>
#include <string.h>
#include <string>
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
bool found=false;
vector<vector<int>> g;
vector<pair<int,int>> time;
int cnt=0;

bool dfs (int i,int curr){

    if (time[i].second != -1) return 0;
    if (time[i].first != -1 && time[i].second == -1){
        cnt = curr-time[i].first;
        if (cnt>k){
            found=true;
            cout<<cnt--<<endl<<i<<" ";
            return 1;
        }
        else return 0;
    }
    time[i].first=curr;

    for (int j : g[i]){
        if (!found){
            if (dfs(j, curr+1)){
                if (cnt-->0) cout<<i<<" ";
                return 1;
            }
        }
        else break;
    }

    time[i].second=curr+1;
    return 0;
}

int main(){

    cin>>n>>m>>k;
    for (int i=0;i<=n;i++){
        vector<int> v;
        g.push_back(v);
        time.push_back(make_pair(-1,-1));
    }

    for (int i=1;i<=m;i++){
        int a,b; cin>>a>>b;
        g[a].push_back(b);
        g[b].push_back(a);
    }

    while (!found){
        int curr=0;
        for (int i=1;i<=n;i++){
            if (time[i].first == -1){
                if (dfs(i,0)) break;
            }
        }
    }

}
