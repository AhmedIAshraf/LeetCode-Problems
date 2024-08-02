#include <iostream>
#include <bits/stdc++.h>

#define PI 3.14159265359
#define ull unsigned long long
#define ll long long
#define sort(v) sort(v.begin(), v.end())
#define revSort(v) sort(v.rbegin(), v.rend())
using namespace std;

int n, k;
int minCost = INT_MAX;
int num;
string str, minNum = "-1";
vector<bool> dp(10, 0);
string sorted;
vector<int> mins;

void qualify(int i)
{
    if (i == n)
        return;
    if (dp[sorted[i] - '0'])
        return qualify(i + 1);

    dp[sorted[i] - '0'] = 1;
    int l = i - 1, r = i + 1;
    int t = 1, cost = 0;
    while (t < k && (l > -1 || r < n))
    {
        if (l == -1 || (abs(sorted[l] - sorted[i]) > abs(sorted[r] - sorted[i]) && r < n))
            cost += abs(sorted[r++] - sorted[i]);
        else if (r == n || abs(sorted[l] - sorted[i]) <= abs(sorted[r] - sorted[i]))
            cost += abs(sorted[l--] - sorted[i]);
        t++;
    }

    if (t == k && cost < minCost)
    {
        mins.clear();
        mins.push_back(sorted[i] - '0');
        minCost = cost;
    }
    else if (t == k && cost == minCost)
        mins.push_back(sorted[i] - '0');
    qualify(i + 1);
}

void minChanges(string s)
{
    bool repeat = true;
    int cnt = 0;
    for (int j = 0; j < 10 && cnt < k; j++)
    {
        int cmp = num;
        if (j)
        {
            if (repeat)
                cmp += j;
            else
                cmp -= j;
        }
        if (repeat)
        {
            for (int i = 0; i < n && cnt < k; i++)
            {
                if (cmp == s[i] - '0')
                {
                    s[i] = char(num + '0');
                    cnt++;
                }
            }
        }
        else
        {
            for (int i = n - 1; i >= 0 && cnt < k; i--)
            {
                if (cmp == s[i] - '0')
                {
                    s[i] = char(num + '0');
                    cnt++;
                }
            }
        }
        if (!j)
            continue;
        if (repeat)
            j--;
        repeat = !repeat;
    }

    if (minNum == "-1")
        minNum = s;
    else
        minNum = min(minNum, s);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> n >> k >> str;

    sorted = str;
    sort(sorted);
    qualify(0);

    dp = vector<bool>(10, 0);
    for (int i : mins)
    {
        if (!dp[i])
        {
            num = i;
            dp[i] = 1;
            minChanges(str);
        }
    }
    cout << minCost << endl
         << minNum;
}
