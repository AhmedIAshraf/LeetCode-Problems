#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <vector>
#include <queue>
#include <deque>
#include <stack>
#define PI 3.14159265359
using namespace std;

vector<long> primes (long n){
    vector<long> factors= {0,0,0,0};
    while (n!=factors[3]){
        factors[3] = n;
        if (n%2==0){
            factors[0]++;
            n/=2;
        }if (n%3==0){
            factors[1]++;
            n/=3;
        }if (n%5==0){
            factors[2]++;
            n/=5;
        }
    }
    return factors;
}

int main(){
    long a,b; cin>>a>>b;
    vector<long> A= primes(a);
    vector<long> B= primes(b);


    if (A[3]!=B[3]) cout<<-1;
    else{
        int sum=0;
        for (int i=0;i<3;i++){
            sum += abs(A[i]-B[i]);
        }
        cout<<sum;
    }

    return 0;
}
