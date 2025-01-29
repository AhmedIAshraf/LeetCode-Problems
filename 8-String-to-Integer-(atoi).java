class Solution {
    public int myAtoi(String s) {
        byte sign=1;
        int number=0, n=s.length();
        int i=0;
        

        while(i<n && s.charAt(i)==' ') {
            i++;
        }
        if (i>=n) return 0;
        
        if (s.charAt(i)=='-') {
            sign = -1;
            i++;
        }
        else if (s.charAt(i)=='+') i++;
        else if (!(s.charAt(i)>='0' && s.charAt(i)<='9')) return number;
        
        while(i<n){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                if (10*(long)number + (s.charAt(i)-'0') > Integer.MAX_VALUE){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                number = 10*number + (s.charAt(i)-'0');
                i++;
            }
            else return number*sign;
        }
        return number*sign;
    }
}