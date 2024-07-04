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


int main(){

    long long n,k; cin>>n>>k;
    long long mx = ((k*(k-1))/2)+1;
    long long cnt=0;

    if (n==1) cout<<0;
    else if(n<=k) cout<<1;
    else if(n>mx) cout<<-1;
    else if (n==mx) cout<<k-1;
    else{                           // k<n<mx
        unsigned long long sumK = k*(k+1)/2;
        long long l=2, r=k;
        while(r>l){
            long long m = l + (r-l)/2;
            unsigned long long sumM = m*(m+1)/2;
            if (sumK-sumM-(k-m-1)==n){
                cout<<k-m;
                return 0;
            }
            else if (sumK-sumM-(k-m-1)<n){
                if (sumK - ((m-1)*(m)/2) - (k-m) > n){
                    cout<<k-(m-1);
                    return 0;
                }
                else r=m;
            }
            else{
                if (sumK - ((m+1)*(m+2)/2) - (k-m-2) < n){
                    cout<<k-m;
                    return 0;
                }
                else l=m;
            }
        }
    }
}

