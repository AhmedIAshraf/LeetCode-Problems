class Solution {
    public boolean isValid(String s) {
        if (s.length()%2 == 1) return false;
        Stack<Character> stk = new Stack<>();
        for (char c:s.toCharArray()){
            if (c==')'){
                if (stk.empty() || stk.pop() != '(') return false;
            }
            else if (c=='}'){
                if (stk.empty() || stk.pop() != '{') return false;
            }
            else if (c==']'){
                if (stk.empty() || stk.pop() != '[') return false;
            }
            else stk.push(c);
        }
        return stk.empty();
    }
}