#include <iostream>
#include <bits/stdc++.h>

#define PI 3.14159265359
#define ull unsigned long long
#define ascSort(v) sort(v.begin(), v.end())
#define desSort(v) sort(v.rbegin(), v.rend())
using namespace std;

int main()
{
    int n, q;
    cin >> n;
    vector<ull> v(n + 1, 0), sortedV(n + 1, 0);
    for (int i = 1; i <= n; i++)
    {
        cin >> v[i];
        sortedV[i] = v[i];
        v[i] += v[i - 1];
    }
    ascSort(sortedV);
    for (int i = 1; i <= n; i++)
        sortedV[i] += sortedV[i - 1];

    cin >> q;
    while (q--)
    {
        int t, a, b;
        cin >> t >> a >> b;
        if (t == 1)
            cout << v[b] - v[a - 1];
        else
            cout << sortedV[b] - sortedV[a - 1];
        cout << endl;
    }
}
