class Solution {
    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        int l=0, r=number.length()-1;
        while(r>l){
            if (number.charAt(l++) != number.charAt(r--))
                return false;
        }
        return true;
    }
}