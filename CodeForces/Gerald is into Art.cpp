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

    int a1, b1, a2, b2, a3, b3;
    cin >> a1 >> b1 >> a2 >> b2 >> a3 >> b3;
    vector<int> a = {a2, b2};
    vector<int> b = {a3, b3};
    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < 2; j++)
        {
            int first = a[i] + b[j];
            int sec = max(a[1 - i], b[1 - j]);
            if (max(first, sec) <= max(a1, b1) && min(first, sec) <= min(a1, b1))
            {
                cout << "YES";
                return 0;
            }
        }
    }
    cout << "NO";
}
