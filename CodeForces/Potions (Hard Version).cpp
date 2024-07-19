#include <iostream>
#include <bits/stdc++.h>

#define PI 3.14159265359
#define ull unsigned long long
#define desSort(v) sort(v.begin(), v.end())
#define ascSort(v) sort(v.rbegin(), v.rend())
using namespace std;

int main()
{
    int n;
    cin >> n;
    vector<long long> v(n);
    int maxNum = 0;
    long long health = 0;
    multiset<long long> negatives;

    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
        if (v[i] >= 0)
        {
            maxNum++;
            health += v[i];
        }
        else
        {
            if (health + v[i] >= 0)
            {
                health += v[i];
                maxNum++;
                negatives.insert(v[i]);
            }
            else if (!negatives.empty() && abs(v[i]) < abs(*negatives.begin()))
            {
                health -= *negatives.begin();
                negatives.erase(negatives.begin());
                health += v[i];
                negatives.insert(v[i]);
            }
        }
    }

    cout << maxNum;
}
