class Solution {
    public int strStr(String haystack, String needle) {
        int n  = haystack.length();
        int m  = needle.length();
        for (int i=0; i<n; i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                int j = 1;
                while (i + j < n && j < m && haystack.charAt(j+i) == needle.charAt(j)){
                    j++;
                }
                if 
                (j == m){
                    return i;
                }
            }
        }

        return -1;
    }
}