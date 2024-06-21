class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        
        int sure=0, extra=0, temp=0;
        int l=0, c=0;

        for (int i=0;i<customers.size();i++){
            if (!grumpy[i]) sure+=customers[i];
            else temp+=customers[i];
            
            c++;
            if (c==minutes){
                extra=max(extra,temp);
                if (grumpy[l]) temp-=customers[l];
                c--, l++;
            }
        }

        return (sure+extra);

    }
};
