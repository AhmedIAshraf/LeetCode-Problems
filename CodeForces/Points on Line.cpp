#include <iostream>
#include <bits/stdc++.h>

#define PI 3.14159265359
#define ull unsigned long long
#define ll long long
#define ascSort(v) sort(v.begin(), v.end())
#define desSort(v) sort(v.rbegin(), v.rend())
using namespace std;

int main()
{
    ll n, d;
    cin >> n >> d;
    vector<ll> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];

    ll l = 0, i = 2;
    ll num = 0, total = 0;
    while (i < n && l < n - 2)
    {
        if (v[i] - v[l] <= d)
        {
            num = i - l - 1;
            total += (num * (num + 1)) / 2;
            i++;
        }
        else if (v[i] - v[l] > d)
        {
            while (v[i] - v[l] > d)
                l++;
            if (i - l == 1)
                i++;
        }
    }
    cout << total;
}
