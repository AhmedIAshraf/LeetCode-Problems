#include <iostream>
#include <bits/stdc++.h>

#define PI 3.14159265359
#define ull unsigned long long
#define ll long long
#define sort(v) sort(v.begin(), v.end())
#define revSort(v) sort(v.rbegin(), v.rend())
using namespace std;

void print(vector<vector<int>> v)
{
    for (auto vec : v)
    {
        for (auto i : vec)
            cout << i << " ";
        cout << endl;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k, e, o;
    cin >> n >> k >> e;
    o = k - e;

    vector<int> v, restOfEvens;
    vector<vector<int>> evens, odds;
    int m, eIdx = 0, oIdx = 0;
    bool eDone = (e > 0) ? 0 : 1;
    bool oDone = (o > 0) ? 0 : 1;
    for (int i = 0; i < n; i++)
    {
        cin >> m;
        if (m % 2 == 0)
        {
            if (!eDone)
                evens.push_back({1, m});
            else if (e > 0)
            {
                evens[eIdx][0]++;
                evens[eIdx++].push_back(m);
            }
            else if (e == 0 && o != 0)
                restOfEvens.push_back(m);
            else
            {
                cout << "NO";
                return 0;
            }
            if (!evens.empty() && e > 0 && evens.size() % e == 0)
            {
                eIdx = 0;
                eDone = 1;
            }
        }
        else
            v.push_back(m);
    }
    eIdx = 0;

    for (int i = 0; i < v.size(); i++)
    {
        if (!oDone)
            odds.push_back({1, v[i]});
        else
        {
            if (!eDone)
            {
                if (v.size() - i >= 2)
                {
                    evens.push_back({2, v[i], v[i + 1]});
                    i++;
                }
                else
                {
                    cout << "NO";
                    return 0;
                }
                if (evens.size() == e)
                    eDone = 1;
            }
            else if (eDone && o == 0)
            {
                if ((v.size() - i) % 2)
                {
                    cout << "NO";
                    return 0;
                }
                else
                {
                    evens[eIdx][0] += 2;
                    evens[eIdx].push_back(v[i]);
                    evens[eIdx++].push_back(v[i + 1]);
                    i++;
                }
                if (eIdx == evens.size())
                    eIdx = 0;
            }
            else
            {
                if ((v.size() - i) % 2)
                {
                    cout << "NO";
                    return 0;
                }
                else
                {
                    odds[oIdx][0] += 2;
                    odds[oIdx].push_back(v[i]);
                    odds[oIdx++].push_back(v[i + 1]);
                    i++;
                }
            }
        }
        if (!odds.empty() && o > 0 && odds.size() % o == 0)
        {
            oIdx = 0;
            oDone = 1;
        }
    }
    for (int i = 0; i < restOfEvens.size() && odds.size(); i++)
    {
        int idx = i % odds.size();
        odds[idx][0]++;
        odds[idx].push_back(restOfEvens[i]);
    }

    if (evens.size() != e || odds.size() != o)
        cout << "NO";
    else
    {
        cout << "YES" << endl;
        print(evens);
        print(odds);
    }
}
