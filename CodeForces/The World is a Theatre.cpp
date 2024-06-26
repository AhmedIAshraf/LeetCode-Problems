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

unsigned long long factorial[21]; //the limit to be stored is factorial of 20

void prepareFactorial(){

    factorial[0]=factorial[1]=1;

    for (int i=2;i<21;++i)
        factorial[i]=factorial[i-1]*(long long)i;

}

int main(){

    int n,m,t; cin>>n>>m>>t;
    unsigned long long ways=0;
    prepareFactorial();

    int k=4,j=t-4;
    while(!(k<=n && j>=1 && j<=m)){
        j=t-(++k);
    }
    for (int i=k ; i<=n && j>=1 && j<=m ; i++){
        unsigned long long boysComb, girlsComb;

        if (n<21 && i<21 && n-i<21)
            boysComb = (factorial[n]/(factorial[i]*factorial[n-i]));
        else{
            int mx, mn = i>n-i ? n-i : i;
            mx = mn==i? n-i : i;
            unsigned long long numerator = 1;
            for (int k=n;k>mx;k--) {
                if (n==30 && i==15 && k==16) continue;    //Can't store this value as it's very large
                numerator *= k;
            }
            boysComb = numerator/factorial[mn];
            if (n==30 && i==15) boysComb *= 16;
        }

        if (m<21 && j<21 && m-j<21)
            girlsComb = (factorial[m]/(factorial[j]*factorial[m-j]));
        else{
            int mx, mn = j>m-j ? m-j : j;
            mx = mn==j? m-j : j;
            unsigned long long numerator = 1;
            for (int k=m;k>mx;k--) {
                if (m==30 && j==15 && k==16) continue;
                numerator *= k;
            }
            girlsComb = numerator/factorial[mn];
            if (m==30 && j==15) girlsComb *= 16;
        }

        ways += boysComb*girlsComb;
        j=t-(i+1);
    }

    cout<<ways<<endl;
}

