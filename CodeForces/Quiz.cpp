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
    unsigned long long n,m,k; cin>>n>>m>>k;
    if (m==0){
        cout<<0<<endl;
        return 0;
    }

    unsigned long long mn=0;
    unsigned long long s=n-m; //number of separators (empty spaces)
    long long consecutivePoints = n-(s*k);
    if (consecutivePoints<0){
        cout<<m<<endl;
        return 0;
    }
    unsigned long long doublingTimes = consecutivePoints/k;
    unsigned long long additionalInConsecutive = consecutivePoints%k;
    //doubling early is better as the score is still small (if it's inevitable), then when it's not inevitable to double,
    //put empty spaces with k-1 spaces in between these spaces

    if(doublingTimes>0){
        unsigned long long power=1;
        while (doublingTimes>=30){
            power*=pow(2,30);
            power%=1000000009;
            doublingTimes-=30;
        }
        power*=pow(2,doublingTimes);
        power%=1000000009;
        power--;
        power*=2*k;
        power%=1000000009;
        mn=power;
    }


    mn+=additionalInConsecutive;
    mn%=1000000009 ;
    mn+=s*(k-1);
    mn%=1000000009 ;

    cout<<mn <<endl;
}


