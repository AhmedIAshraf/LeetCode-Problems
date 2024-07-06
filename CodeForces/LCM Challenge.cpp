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

unsigned long long gcd(unsigned long long a, unsigned long long b){
    if (b==0) return a;
    return gcd(b, a%b);
}
int main(){

    int n; cin>>n;
    unsigned long long mx=1;
    if (n<=2){
        cout<<n;
        return 0;
    }
    for (long long i=n;i>=n-10&&i>0;i--){
        for (long long j=i-1;j>=n-11&&j>0;j--){
            for (long long k=j-1;k>=n-12&&k>0;k--){
                unsigned long long l = (i*j)/gcd(i,j);
                l = (l*k)/gcd(l, k);
                if(l>mx) mx=l;
            }
        }
    }
    cout<<mx;
}


