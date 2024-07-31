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

    int r1, r2, c1, c2, d1, d2;
    cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
    int b = 0, c = 0, d = 0;
    vector<bool> done(10, 0);

    for (int a = 1; a < r1 && a < c1 && a < d1; a++)
    {
        done = vector<bool>(10, 0);
        done[a] = 1;

        b = r1 - a;
        if (done[b])
            continue;
        done[b] = 1;

        c = c1 - a;
        if (done[c])
            continue;
        done[c] = 1;

        d = d1 - a;
        if (done[d])
            continue;
        done[d] = 1;

        if (a * b * c * d > 0 && a <= 9 && b <= 9 && c <= 9 && d <= 9)
        {
            if (c + d == r2 && b + d == c2 && b + c == d2)
            {
                cout << a << " " << b << endl
                     << c << " " << d;
                return 0;
            }
        }
    }
    cout << -1;
}
