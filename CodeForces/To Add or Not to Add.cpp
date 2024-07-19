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
    desSort(v);

    ll repeated = 1, num = v[0], op = 0;
    ll max_repeated = INT_MIN, min_num = INT_MAX;
    int l = 0;
    for (int i = 1; i < n && l < n - 1; i++)
    {
        op += (v[l] - v[i]);
        if (op <= d)
            repeated++;
        else
        {
            if (repeated >= max_repeated)
                min_num = min(min_num, num);
            max_repeated = max(max_repeated, repeated);
            repeated = i - l - 1;
            op -= (v[l] - v[i]);
            op -= (v[l] - v[l + 1]) * (i - l - 1);
            l++;
            i--;
            if (l < n)
                num = v[l];
        }
    }
    if (repeated >= max_repeated)
        min_num = min(min_num, num);
    max_repeated = max(max_repeated, repeated);
    cout << max_repeated << " " << min_num;
}
