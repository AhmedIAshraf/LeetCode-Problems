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

int main(){

   int n; cin>>n;
   int n1; cin>>n1;
   vector<int> v1(n1), v2(n-n1);
   for(int i=0;i<n1;i++) cin>>v1[i];
   int n2; cin>>n2;
   for(int i=0;i<n2;i++) cin>>v2[i];

   bool inf=false;
   int iter=0;
   while(!v1.empty() && !v2.empty() && !inf){
        int t1=v1[0];
        int t2=v2[0];
        v1.erase(v1.begin(),v1.begin()+1);
        v2.erase(v2.begin(),v2.begin()+1);
        if(t1>t2){
            v1.push_back(t2);
            v1.push_back(t1);
        }
        else{
            v2.push_back(t1);
            v2.push_back(t2);
        }
        iter++;
        if (iter>pow(2,n)) inf=true;

   }
  
   iter = inf ? -1 : iter;
   cout<<iter<<" ";
   if (iter!=-1){
        if (v1.empty()) cout<<2;
        else cout<<1;
   }
}
