#include <iostream>
#include <bits/stdc++.h>

#define PI 3.14159265359
#define MOD 1000000007
#define ull unsigned long long
#define ll long long
#define Sort(v) sort(v.begin(), v.end())
#define revSort(v) sort(v.rbegin(), v.rend())
using namespace std;

int n;
vector<int> v(0);
vector<vector<int>> dp(0, vector<int>(2, -1));

ll solve(int i, int turn)
{
    if (i == n - 1)
    {
        if (turn == 1)
            return 0;
        else
            return v[i];
    }
    if (i >= n)
        return 0;
    if (dp[i][turn] != -1)
        return dp[i][turn];

    int r1 = INT_MAX, r2 = INT_MAX;
    if (turn == 1) // my turn
    {
        r1 = solve(i + 1, 0);
        r2 = solve(i + 2, 0);
    }
    else
    {
        r1 = v[i] + solve(i + 1, 1);
        if (i + 1 < n)
            r2 = v[i] + v[i + 1] + solve(i + 2, 1);
    }
    return dp[i][turn] = min(r1, r2);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--)
    {
        cin >> n;
        v = vector<int>(n);
        dp = vector<vector<int>>(n + 1, vector<int>(2, -1));
        for (int i = 0; i < n; i++)
            cin >> v[i];

        cout << solve(0, 0) << endl;
    }
}
