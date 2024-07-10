#include <iostream>
#include <cstring>
#include <string.h>
#include <unordered_map>
#include <string>
#include <cmath>
#include <algorithm>
#include <vector>
#include <queue>
#include <deque>
#include <stack>
#include<iterator>
#define PI 3.14159265359
using namespace std;

int main(){

    string components; cin>>components;
    unordered_map<string,int> b,s,c;
    cin>>b["num"]>>s["num"]>>c["num"];
    cin>>b["price"]>>s["price"]>>c["price"];
    b["req"]=s["req"]=c["req"]=0;
    for (int i=0;i<components.length();i++){
        if (components[i]=='B') b["req"]++;
        if (components[i]=='S') s["req"]++;
        if (components[i]=='C') c["req"]++;
    }
    long long r; cin>>r;

    vector<unordered_map<string,int>> v;
    if (b["req"]!=0) v.push_back(b);
    if (s["req"]!=0) v.push_back(s);
    if (c["req"]!=0) v.push_back(c);

    for (int i=0;i<v.size();i++){
        v[i]["left"]=v[i]["num"]%v[i]["req"];
        v[i]["num"]/=v[i]["req"];
    }
    for(int i=0;i<v.size()-1;i++){
        if(v[i+1]["num"]<v[i]["num"]) swap(v[i], v[i+1]);
    }
    if(v.size()>1 && v[1]["num"]<v[0]["num"]) swap(v[0], v[1]);

    r+=v[0]["left"]*v[0]["price"];
    long long cost;
    if (v.size()>1){
        cost=(v[1]["num"]-v[0]["num"])*v[0]["req"];        //get pieces to make the least two equal
        cost *= v[0]["price"];
    }
    else{
        cost=v[0]["req"]*v[0]["price"];
        cout<<v[0]["num"]+(r/cost);
        return 0;
    }

    if (r>=cost){
        r-=cost;
        v[0]["num"] = v[1]["num"];
    }
    else{
        int bought = r/v[0]["price"];
        v[0]["num"] += bought/v[0]["req"];
        cout<<v[0]["num"];
        return 0;
    }


    r+=v[1]["left"]*v[1]["price"];
    if (v.size()==2){
        cost=(v[0]["req"]*v[0]["price"])+(v[1]["req"]*v[1]["price"]);
        cout<<v[1]["num"]+(r/cost);
        return 0;
    }
    else{
        int diff=v[2]["num"]-v[1]["num"];
        cost=diff*(v[0]["req"]*v[0]["price"] + v[1]["req"]*v[1]["price"]);
    }

    if (r>=cost){
        r-=cost;
        v[0]["num"]=v[1]["num"]=v[2]["num"];
        r+=v[2]["left"]*v[2]["price"];
        cost=v[0]["req"]*v[0]["price"]+v[1]["req"]*v[1]["price"]+v[2]["req"]*v[2]["price"];
    }
    else{
        cost = (v[0]["req"]*v[0]["price"] + v[1]["req"]*v[1]["price"]);
    }
    cout<<(v[0]["num"]+(r/cost));

}

