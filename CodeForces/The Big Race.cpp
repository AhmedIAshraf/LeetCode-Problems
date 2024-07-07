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

    unsigned long long n,a,b; cin>>n>>a>>b;
    int digOfA=log(a)/log(10), digOfB=log(b)/log(10), digOfG=log(gcd(a,b))/log(10);
  
    if (n<min(a,b)){
        cout<<"1/1";
        return 0;
    }
    else if (digOfA+digOfB-digOfG>19){
        unsigned long long g = gcd(min(a,b)-1, n);
        cout<<(min(a,b)-1)/g<<"/"<<n/g;
        return 0;
    }

    unsigned long long lcm=(a/gcd(a,b))*b;
    unsigned long long times = (((n/lcm)-1)*min(a,b))+min(a,b)-1;
    times += min(min(a,b), (n%lcm)+1);
    unsigned long long g=gcd(n,times);
    cout<<times/g<<"/"<<n/g;
}
