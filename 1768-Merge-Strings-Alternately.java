class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        int i=0, j=0;
        String merged = "";

        while (i<n && j<m){
            merged += word1.charAt(i++);
            merged += word2.charAt(j++);
        }
        while (i<n){
            merged += word1.charAt(i++);
        }
        while (j<m){
            merged += word2.charAt(j++);
        }

        return merged;
    }
}