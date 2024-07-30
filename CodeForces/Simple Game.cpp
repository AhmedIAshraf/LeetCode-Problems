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

    int n, m;
    cin >> n >> m;
    if (n == 1 && m == 1)
        cout << 1;
    else if (n % 2)
    {
        if (m >= (n / 2 + 1))
            cout << m - 1;
        else
            cout << m + 1;
    }
    else
    {
        if (m > n / 2)
            cout << m - 1;
        else
            cout << m + 1;
    }
}
