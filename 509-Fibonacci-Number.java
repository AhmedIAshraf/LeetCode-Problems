class Solution {
    public int fib(int n) {
       
        if (n<2){
            return n;
        }

        int f0 = 0, f1 = 1;
        int f2;
        while(n>1){
            f2 = f0+f1;
            f0 = f1;
            f1 = f2;
            n--;
        }
        return f1;

    }
}