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
    cin >> n;
    vector<int> v(n);
    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
        if (i)
            v[i] += v[i - 1];
    }

    cin >> t;
    vector<pair<int, int>> q(t);
    vector<pair<int, int>> order(t);

    int temp;
    for (int i = 0; i < t; i++)
    {
        cin >> temp;
        q[i] = {temp, i};
    }
    ascSort(q);

    int p1 = 0, p2 = 0;
    while (p2 < t)
    {
        while (p1 < n && v[p1] < q[p2].first)
            p1++;
        order[p2] = {q[p2].second, p1 + 1};
        p2++;
    }

    ascSort(order);
    for (auto p : order)
        cout << p.second << endl;
}
