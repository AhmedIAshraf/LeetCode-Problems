class Solution {
    public boolean isPerfectSquare(int num) {
        int l=1, r=num/2;
        while (r>l){
            int m=(r+l)/2;
            if ((long)m*m == num)
                return true;
            else if ((long)m*m < num)
                l=m+1;
            else
                r=m-1;
        }
        return (l*l==num || r*r==num);
    }
}

