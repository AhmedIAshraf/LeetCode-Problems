class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mp = new HashMap<>();
        int n = s.length();
        for (int i=0; i<n; ++i){
            boolean containTheKey = mp.containsKey(s.charAt(i)); 
            if (containTheKey && mp.get(s.charAt(i)) != t.charAt(i) ||
                !containTheKey && mp.containsValue(t.charAt(i))
            ){
                return false;
            }
            mp.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}