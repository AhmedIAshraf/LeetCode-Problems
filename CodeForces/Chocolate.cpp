
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

    int n; cin>>n;
    vector <long> v(n);
    long long nuts=0, conseq=0, r=1;
    bool one = false;

    for (int i=0;i<n;i++){
        cin>>v[i];
        if (v[i]==1){
            one=true;
            if (conseq) r*=(conseq+1);
            conseq=0;
            nuts++;
        }
        else{
            if (one) conseq++;
        }
    }

    if (!nuts) r=0;
    cout<<r<<endl;
}
