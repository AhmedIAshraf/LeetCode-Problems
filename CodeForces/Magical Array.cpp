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
    for (int i=0;i<n;i++) cin>>v[i];

    long long l=0,r=1;
    long long out=n;
    while (r<n){
        if (l==r) r++;
        else if (v[l]==v[r]) r++;
        else {
            long long num = r-l-1;
            out+=((num+1)*num)/2;
            l=r++;
        }
    }

    if (v[r-1]==v[l]){
        long long num = r-l-1;
        long long a = num%2? ((num+1)/2) : (num/2);
        long long b = num%2? num : num+1;
        out += a*b;
    }

    cout<<out<<endl;
}
