#include <iostream>
#include <bits/stdc++.h>

#define PI 3.14159265359
#define ull unsigned long long
#define ascSort(v) sort(v.begin(), v.end())
#define desSort(v) sort(v.rbegin(), v.rend())
using namespace std;

int main()
{
    int n, t;
    cin >> n >> t;
    vector<int> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];

    int l = 0, mx = 0, curr = 0;
    ull time = 0;
    for (int i = 0; i < n; i++)
    {
        if (time + v[i] <= t)
        {
            time += v[i];
            curr++;
            mx = max(mx, curr);
        }
        else
        {
            time -= v[l++];
            i--;
            curr--;
        }
    }
    cout << mx;
}
