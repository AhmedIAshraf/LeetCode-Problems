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

    int n; cin>>n;
    vector<pair<long long, long long>> boxes(n);
    for (int i=0;i<n;i++) cin>>boxes[i].first>>boxes[i].second;
    sort(boxes.begin(), boxes.end());
    long long num=boxes[0].second, power=boxes[0].first;

    for (int i=1;i<n;i++){
        long long powerDiff=boxes[i].first-power;
        long long lg = ceil(num/(double)(pow(4,powerDiff)));
        if (lg<=boxes[i].second){
            num=boxes[i].second;
            power=boxes[i].first;
        }
    }

    if (num==1)  power++;
    else power+=ceil((double)(log(num))/(double)(log(4)));
    cout<<power;

}
