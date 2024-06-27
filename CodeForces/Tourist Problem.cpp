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

long long GCD(unsigned long long a, int b){
    if (b==0) return a;
    return GCD (b, a%b);
}

int main(){

    long long n; cin>>n;
    unsigned long long diffSum=0,totalDiffSum=0;
    vector <int> v(n);
    for (int i=0;i<n;i++) cin>>v[i];
    sort(v.begin(), v.end());

    for (int i=0;i<n;i++){
        if (i==0) diffSum+=v[i];
        else diffSum+=abs(v[i]-v[0]);
    }

    totalDiffSum=diffSum;
    for (int i=1;i<n;i++){
        long long diff = v[i]-v[i-1];
        diffSum += (diff*i - diff*(n-1-i));
        totalDiffSum += diffSum;
    }

    long long div = GCD(totalDiffSum,n);
    totalDiffSum/=div;
    n/=div;
    cout<<totalDiffSum<<" "<<n<<endl;
}
