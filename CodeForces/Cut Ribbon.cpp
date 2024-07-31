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
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int mx = 0;
    int n, a, b, c;
    cin >> n >> a >> b >> c;
    vector<int> v = {a, b, c};
    desSort(v);

    for (int i = 0; i * v[0] <= n; i++)
    {
        for (int j = 0; i * v[0] + j * v[1] <= n; j++)
        {
            int rem = n - (i * v[0] + j * v[1]);
            if (rem % v[2] == 0)
            {
                if (i + j + (rem / v[2]) <= mx / 2)
                {
                    cout << mx;
                    return 0;
                }
                mx = max(mx, i + j + (rem / v[2]));
                break;
            }
        }
    }
    cout << mx;
}
