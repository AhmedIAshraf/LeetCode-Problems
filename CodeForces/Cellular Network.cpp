#include <iostream>
#include <bits/stdc++.h>

#define PI 3.14159265359
#define ull unsigned long long
#define ascSort(v) sort(v.begin(), v.end())
#define desSort(v) sort(v.rbegin(), v.rend())
using namespace std;

int main()
{
    int n, m;
    cin >> n >> m;
    vector<int> a(n), b(m);
    for (int i = 0; i < n; i++)
        cin >> a[i];
    for (int i = 0; i < m; i++)
        cin >> b[i];

    int p1 = 0, p2 = 0;
    ull longest = 0;
    while (p1 < n)
    {
        while (p2 < m - 1 && abs(a[p1] - b[p2]) >= abs(a[p1] - b[p2 + 1]))
            p2++;
        ull diff = abs(a[p1] - b[p2]);
        longest = max(longest, diff);
        p1++;
    }
    cout << longest;
}
