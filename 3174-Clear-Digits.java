class Solution {
    public String clearDigits (String s) {

        Stack<Character> chars = new Stack<>();
        for (char c : s.toCharArray()){
            if (c >= '0' && c <= '9' && !chars.empty()){
                chars.pop();
            }
            else{
                chars.push(c);
            }
        }

        List<Character> fin = new ArrayList<>();
        while (!chars.empty()){
            fin.add(chars.pop());
        }
        
        int n = fin.size();
        String reversed = "";
        for (int i=n-1; i>=0; i--){
            reversed += fin.get(i);
        }
        
        return reversed;
    }
}