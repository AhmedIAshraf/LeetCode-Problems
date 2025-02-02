class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();
        for (int i=1; i<=n; i++){
            String s=\\;
            if (i%3 == 0) s+=\Fizz\ ;
            if (i%5 == 0) s+=\Buzz\;
            if (s.length() == 0) s=String.valueOf(i);
            ans.add(s);   
        }
        return ans;
    }
}