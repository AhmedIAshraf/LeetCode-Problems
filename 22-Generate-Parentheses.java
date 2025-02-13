class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generator(\\, n, n, ans);
        return ans;
    }

    public void generator (String word, int openPara, int closePara, List<String> ans){
        //openPara => number of remaining required open parantheses
        //closePara => number of remaining required close parantheses
        if (openPara == 0 && closePara == 0){
            ans.add(word);
            return;
        }

        if (openPara > 0){
            generator (word+\(\, openPara-1, closePara, ans);
        }
        if (openPara < closePara){
            generator (word+\)\, openPara, closePara-1, ans);
        }
    } 
}