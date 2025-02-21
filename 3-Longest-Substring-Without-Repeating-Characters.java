import java.util.Hashtable;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        char[] str = s.toCharArray();
        int n = str.length;
        int maxSeq = 0, currMax = 0;
        int lastRemoved = 0;
        Hashtable<Character, Integer> dupIdx = new Hashtable<>();

        for (int i=0; i<n; i++){
            int start = dupIdx.getOrDefault(str[i], -1);

            if (start == -1){
                currMax++;
                maxSeq = Math.max(maxSeq, currMax);
            }
            else{
                currMax = i - start;
                while(lastRemoved < start){
                    dupIdx.remove(str[lastRemoved++]);
                }
                lastRemoved++;
            }
            
            dupIdx.put(str[i], i);
            // Add if not exists and update the last index if exists
        }

        return maxSeq;
    }
}