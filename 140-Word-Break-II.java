class Solution {
    //int n,len;
    //String str;
    List<String> dict,result;
    //String[] dp;

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict=wordDict;
        result = new ArrayList<String>();
        //str=s;
        //n=s.length;
        breakWord(0,1,s);
        return result;
    }

    public void breakWord(int j, int i, String s){
        if(i>s.length()) return;

        String sub = s.substring(j,i);
        if(i==s.length()){
            if(dict.contains(sub)) result.add(s);
            return;
        }
        
        if (dict.contains(sub)){
            String str=s.substring(0,i).concat(" ").concat(s.substring(i,s.length()));
            breakWord(i+1,i+2,str);
        }
        breakWord(j,i+1,s);
    }
}