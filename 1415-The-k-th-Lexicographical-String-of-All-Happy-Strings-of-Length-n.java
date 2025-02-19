class Solution {
    public String getHappyString(int n, int k) {

        int totalNum = (int) Math.pow(2, (n-1)) * 3;
        if (k > totalNum){
            return "";
        }
        
        int charSwitch = totalNum / 3;
        int temp = n;
        char previous = 'z';
        String happyK = "";
        k--;
        while (temp > 0){
            int charOffset = k/charSwitch;
            char append;
            if (previous == 'z'){
                append = charOffset == 0? 'a' : charOffset == 1? 'b' : 'c';
            }
            else if (charOffset == 0){
                if (previous == 'a'){
                    append = 'b';
                }
                else{
                    append = 'a';
                }
            }
            else{
                if (previous == 'c'){
                    append = 'b';
                }
                else{
                    append = 'c';
                }
            }
            happyK += append;
            temp--;
            if (k >= charSwitch){
                k %= charSwitch;
            }
            previous = append;
            charSwitch /= 2;
        }

        return happyK;
    }
}