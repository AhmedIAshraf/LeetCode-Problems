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

    int n,k; cin>>n>>k;
    vector<double> lights(n);
    for (int i=0;i<n;i++) cin>>lights[i];
    sort(lights.begin(), lights.end());

    double mx= max(lights[0], k-lights[n-1]);
    for (int i=1;i<n;i++){
        mx=max(mx, (lights[i]-lights[i-1])/2 );
    }

    printf("%10f",mx);
    //cout<<mx%10;

}
