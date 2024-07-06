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

int gcd(int a, int b){
    if (b==0) return a;
    return gcd(b, a%b);
}
int main(){

    int a,b; cin>>a>>b;
    int c=gcd(a,b);
    if ((c>1&&max(a,b)<c*min(a,b))||abs(a-b)<=1) cout<<"Equal";
    else if (a<b) cout<<"Dasha";
    else cout<<"Masha";

}

