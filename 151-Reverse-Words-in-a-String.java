class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(\ \);
        String sentence = \\;
        
        int n = words.length;
        for (int i=n-1; i>=0; i--){
            if (words[i].length() > 0 && words[i].charAt(0) != ' ')
                sentence += words[i]+\ \;  
        }
        return sentence.substring(0, sentence.length()-1);
    }
}